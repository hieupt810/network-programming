package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Ex3_Server {
    Vector<Process> clientList = new Vector<Process>();

    public static void main(String[] args) {
        try {
            new Ex3_Server();
        } catch (IOException e) {
            System.out.println("Failed to create server");
        }
    }

    public Ex3_Server() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Process p = new Process(socket, this);
                clientList.add(p);
                p.start();
            }
        }
    }

    private static class Process extends Thread {
        Socket socket;
        Ex3_Server server;

        public Process(Socket socket, Ex3_Server server) {
            this.socket = socket;
            this.server = server;
        }

        public void run() {
            while (true) {
                try {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String message = dis.readUTF();

                    for (int i = server.clientList.size() - 1; i >= 0; i--) {
                        Process clientProcess = server.clientList.get(i);
                        try {
                            DataOutputStream dos = new DataOutputStream(clientProcess.socket.getOutputStream());

                            if (clientProcess != this) {
                                dos.writeUTF(clientProcess.socket.getInetAddress() + ": " + message);
                            } else {
                                dos.writeUTF("You: " + message);
                            }
                        } catch (IOException e) {
                            server.clientList.remove(clientProcess);
                        }
                    }
                } catch (IOException e) {
                    break;
                }
            }
        }
    }
}
