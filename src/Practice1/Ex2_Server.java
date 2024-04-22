package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.mariuszgromada.math.mxparser.Expression;

public class Ex2_Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Process(socket).start();
            }
        }
    }

    private static class Process extends Thread {
        Socket socket;

        public Process(Socket socket) {
            this.socket = socket;
        }

        public static String calculate(String expression) {
            Expression e = new Expression(expression);
            return String.valueOf(e.calculate());
        }

        public void run() {
            try {
                socket.setSoTimeout(10000);

                while (true) {
                    DataInputStream dis = new DataInputStream(this.socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());

                    String message = dis.readUTF();
                    dos.writeUTF(calculate(message));
                }
            } catch (IOException e) {
                System.out.println("Failed to process socket connection");
            }
        }
    }
}