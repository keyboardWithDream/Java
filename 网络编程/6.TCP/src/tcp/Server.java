package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉TCP流程
 * 创建服务器
 * 1.指定端口 使用ServerSocket 创建服务器
 * 2.阻塞式等待连接
 * 3.操作: 输入输出流
 * 4.释放资源
 * @Author: Harlan
 * @Date: 2020/6/18 10:58
 */
public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("======Server Run=====");
        //指定端口 创建服务器
        ServerSocket server = new ServerSocket(8888);

        //阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接...");

        //操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);

        //释放
        dis.close();
        client.close();
        server.close();
    }
}
