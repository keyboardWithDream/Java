package tcp_talk;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 18:11
 */
public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("=====Client Run=====");


        //连接:使用Socket 创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8899);

        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
