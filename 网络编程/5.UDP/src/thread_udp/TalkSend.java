package thread_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * 加入多线程
 * @Author: Harlan
 * @Date: 2020/6/17 21:52
 */
public class TalkSend implements Runnable{

    private DatagramSocket ds;
    private BufferedReader br;
    private final InetSocketAddress iSa;

    public TalkSend(String hostname, int sendPort, int recvPort) {
        try {
            this.ds = new DatagramSocket(sendPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.iSa = new InetSocketAddress(hostname, recvPort);
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String QUIT = "quit!";
            String connect;
            do {
                connect = br.readLine();
                byte[] data = connect.getBytes();
                DatagramPacket packet = new DatagramPacket(data, 0, data.length, iSa);
                ds.send(packet);
                if (connect.equals(QUIT)){
                    break;
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ds.close();
        }
    }
}
