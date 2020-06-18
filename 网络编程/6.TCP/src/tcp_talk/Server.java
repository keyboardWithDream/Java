package tcp_talk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 17:48
 */
public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("=====Server Run=====");

        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8899);

        //阻塞式接收 accept
        while (true){
            Socket client = server.accept();
            System.out.println("=====Users Conn=====");
            TalkThread talkThread = new TalkThread(client);
            new Thread().start();
        }
    }
}
