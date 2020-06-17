package udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: Harlan
 * @Date: 2020/6/16 21:12
 */
public class UdpTalkServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(6666);
        final String QUIT_TALK = "quit!";
        boolean flag = true;
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container,0, container.length);
        while (flag){
            server.receive(packet);
            String data = new String(container,0,packet.getLength());
            System.out.println(data);
            if (data.equals(QUIT_TALK)){
                flag = false;
            }
        }
        server.close();
    }
}
