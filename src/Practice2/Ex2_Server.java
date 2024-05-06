package Practice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.mariuszgromada.math.mxparser.Expression;

public class Ex2_Server {
    public static void main(String[] args) {
        new Ex2_Server();
    }

    private String calculate(String expression) {
        Expression e = new Expression(expression);
        return String.valueOf(e.calculate());
    }

    public Ex2_Server() {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                String receiveString = new String(packet.getData(), 0, packet.getLength());

                String sendString = calculate(receiveString);
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