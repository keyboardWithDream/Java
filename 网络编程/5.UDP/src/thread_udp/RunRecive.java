package thread_udp;

/**
 * @Author: Harlan
 * @Date: 2020/6/17 22:43
 */
public class RunRecive {

    public static void main(String[] args) {
        Thread receiveThread = new Thread(new TalkReceive());
        receiveThread.start();
    }
}
