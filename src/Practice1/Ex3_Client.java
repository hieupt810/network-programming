package Practice1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex3_Client extends JFrame {
    Socket soc;
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
                    DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                    dos.writeUTF(msg);
                } catch (Exception e1) {
                    System.out.println("Failed to send message to server");
                }
            }
        });
        p.add(BorderLayout.EAST, b);
        this.getContentPane().add(BorderLayout.SOUTH, p);

        try {
            soc = new Socket("localhost", 8080);
        } catch (Exception e) {
            System.out.println("Failed to connect to server");
            isRunning = false;
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        DataInputStream dis = new DataInputStream(soc.getInputStream());
                        String msg = dis.readUTF();
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
