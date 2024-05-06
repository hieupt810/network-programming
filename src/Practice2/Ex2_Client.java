package Practice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Ex2_Client {
    public static void main(String[] args) {
        new Ex2_Client();
    }

    public Ex2_Client() {
        try (DatagramSocket socket = new DatagramSocket()) {
            String sendString = "5+13-(12-4*6)-((3+4)-5)";
            DatagramPacket sendPacket = new DatagramPacket(sendString.getBytes(), sendString.length(),
                    InetAddress.getLocalHost(), 5000);
            socket.send(sendPacket);

            byte receiveBytes[] = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBytes, 1024);
            socket.receive(receivePacket);
            System.out.println("Received: " + new String(receiveBytes, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
