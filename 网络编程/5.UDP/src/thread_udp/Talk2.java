package thread_udp;

import java.net.SocketException;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:22
 */
public class Talk2 {

    public static void main(String[] args) throws SocketException {
        Thread receiveThread = new Thread(new TalkReceive(5555));
        Thread sendThread = new Thread(new TalkSend("localhost",7777,8888));
        receiveThread.start();
        sendThread.start();
    }
}
