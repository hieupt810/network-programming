package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex1 {
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

        private String toUpperCase(String input) {
            return input.toUpperCase();
        }

        private String toLowerCase(String input) {
            return input.toLowerCase();
        }

        private int countWords(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }
            String[] words = input.split("\\s+");
            return words.length;
        }

        public void run() {
            try {
                socket.setSoTimeout(10000);

                while (true) {
                    DataInputStream dis = new DataInputStream(this.socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());

                    String message = dis.readUTF();
                    dos.writeUTF(toUpperCase(message) + " " + toLowerCase(message) + " " + countWords(message));
                }
            } catch (IOException e) {
                System.out.println("Failed to process socket connection");
            }
        }
    }
}