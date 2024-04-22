package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex2_Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String hostName = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostName, port)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("5+13-(12-4*6)-((3+4)-5)");

            while (true) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.out.println(dis.readUTF());
            }
        }
    }
}
