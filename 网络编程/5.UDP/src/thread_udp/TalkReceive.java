package thread_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:05
 */
public class TalkReceive implements Runnable{

    private DatagramSocket ds;
    private byte[] data = new byte[1024 * 100];

    @Override
    public void run() {
        try {
            ds = new DatagramSocket(6666);
            String QUIT_TALK = "quit!";
            String content;
            DatagramPacket packet = new DatagramPacket(data, 0, data.length);
            do {
                ds.receive(packet);
                content = new String(data,0, packet.getLength());
                System.out.println(content);
                if (content.equals(QUIT_TALK)){
                    break;
                }
            }while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
