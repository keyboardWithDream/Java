package udp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Author: Harlan
 * @Date: 2020/6/16 21:03
 */
public class UdpTalkClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(8888);
        final String QUIT_TALK = "quit!";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String container = reader.readLine();
            byte[] data = container.getBytes();
            DatagramPacket packet = new DatagramPacket(data,0, data.length, new InetSocketAddress("localhost",6666));
            client.send(packet);
            if (container.equals(QUIT_TALK)){
                break;
            }
        }
        client.close();
    }
}
