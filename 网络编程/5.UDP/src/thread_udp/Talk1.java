package thread_udp;

import java.net.SocketException;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:43
 */
public class Talk1 {

    public static void main(String[] args) throws SocketException {
        Thread receiveThread = new Thread(new TalkReceive(8888));
        Thread sendThread = new Thread(new TalkSend("localhost",6666,5555));
        receiveThread.start();
        sendThread.start();
    }
}
