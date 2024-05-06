package Practice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ex3_Server {
    public static void main(String[] args) {
        new Ex3_Server();
    }

    public Ex3_Server() {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                String receiveString = new String(packet.getData(), 0, packet.getLength());

                if (!receiveString.isEmpty() && !receiveString.isBlank()) {
                    new Process(socket, packet, receiveString).start();
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static class Process extends Thread {
        DatagramSocket socket;
        DatagramPacket packet;
        String receiveString;

        public Process(DatagramSocket socket, DatagramPacket packet, String receiveString) {
            this.socket = socket;
            this.packet = packet;
            this.receiveString = receiveString;
        }

        public void run() {
            try {
                while (true) {
                    DatagramPacket sendPacket = new DatagramPacket(receiveString.getBytes(), receiveString.length(),
                            packet.getAddress(), packet.getPort());
                    socket.send(sendPacket);
                    System.out.println("Sent: " + receiveString);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }
}
