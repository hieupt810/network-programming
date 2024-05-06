package Practice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ex1_Server {
    public static void main(String[] args) {
        new Ex1_Server();
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

    public Ex1_Server() {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                String receiveString = new String(packet.getData(), 0, packet.getLength());

                String sendString = toUpperCase(receiveString) + "; " + toLowerCase(receiveString) + "; "
                        + countWords(receiveString);

                DatagramPacket sendPacket = new DatagramPacket(sendString.getBytes(), sendString.length(),
                        packet.getAddress(), packet.getPort());
                socket.send(sendPacket);
                System.out.println("Sent: " + sendString);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}