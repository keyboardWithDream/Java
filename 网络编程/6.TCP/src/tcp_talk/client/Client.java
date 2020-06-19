package tcp_talk.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:09
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",10000);
        System.out.println("====CLIENT RUN====");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名: ");
        String name = br.readLine();
        new Thread(new Send(client, name)).start();
        new Thread(new Receive(client)).start();
    }
}

