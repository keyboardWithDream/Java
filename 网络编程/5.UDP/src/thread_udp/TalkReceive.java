package thread_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:05
 */
public class TalkReceive implements Runnable{

    private final DatagramSocket ds;
    private final byte[] data = new byte[1024 * 100];

    public TalkReceive(int port) throws SocketException {
        this.ds = new DatagramSocket(port);
    }

    @Override
    public void run() {
        try {
            String QUIT_TALK = "quit!";
            String content;
            DatagramPacket packet = new DatagramPacket(data, 0, data.length);
            do {
                ds.receive(packet);
                content = new String(data,0, packet.getLength());
                System.out.println(new Date().toString() + "收到的消息: " + content);
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
