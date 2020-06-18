package tcp_login;

import java.io.IOException;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 12:38
 */
public class SRun {

    public static void main(String[] args) throws IOException {
        new Thread(new Server(8888)).start();
    }
}
