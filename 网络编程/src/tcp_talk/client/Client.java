package tcp_talk.client;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:09
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8899);
        System.out.println("====CLIENT RUN====");
        new Thread(new Receive(client)).start();
        new Thread(new Send(client)).start();
    }
}

