package Practice2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex3_Client extends JFrame {
    DatagramSocket socket;
    Boolean isRunning = true;

    public static void main(String arg[]) {
        new Ex3_Client();
    }

    public Ex3_Client() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 400);
        this.getContentPane().setLayout(new BorderLayout());

        JTextArea ta = new JTextArea("");
        ta.setEditable(false);
        this.getContentPane().add(BorderLayout.CENTER, ta);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JTextField tf = new JTextField("");
        p.add(BorderLayout.CENTER, tf);

        JButton b = new JButton("Send");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = tf.getText();
                try {
                    DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(),
                            InetAddress.getLocalHost(), 5000);
                    socket.send(sendPacket);
                } catch (Exception e1) {
                    System.out.println("Failed to send message to server");
                }
            }
        });
        p.add(BorderLayout.EAST, b);
        this.getContentPane().add(BorderLayout.SOUTH, p);

        try {
            socket = new DatagramSocket();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            isRunning = false;
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        byte receiveBytes[] = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveBytes, 1024);
                        socket.receive(receivePacket);

                        String msg = new String(receiveBytes, StandardCharsets.UTF_8);
                        ta.setText(msg + "\n" + ta.getText());
                    } catch (Exception e) {
                        System.out.println("Failed to receive message from server");
                        isRunning = false;
                        System.exit(1);
                    }
                }
            }
        });
        t.start();
        this.setVisible(true);
    }

}
