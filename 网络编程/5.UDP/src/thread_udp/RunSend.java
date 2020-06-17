package thread_udp;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:22
 */
public class RunSend {

    public static void main(String[] args) {
        Thread sendThread = new Thread(new TalkSend());
        sendThread.start();
    }
}
