package tcp_login;

import java.io.IOException;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 12:38
 */
public class CRun {

    public static void main(String[] args) throws IOException {

        new Thread(new Client("localhost",8888)).start();
    }
}
