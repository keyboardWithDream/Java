package udp;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.*;

/**
 * 发送端
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备数据 一定转成字节数组
 * 3.封装成DatagramPacket 包裹,需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @Author: Harlan
 * @Date: 2020/6/16 17:24
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        clientSend("./5.UDP/src/img/send.jpg");
    }

    public void sendMessage() throws IOException {
        System.out.println("发送方启动中...");

        //使用DatagramSocket 指定端口创建发送端
        DatagramSocket client = new DatagramSocket(8888);

        //准备数据
        String msg = "这是一段发送的消息作为测试...";
        byte[] data = msg.getBytes("UTF-8");

        //封装
        DatagramPacket packet = new DatagramPacket(data,0,data.length, new InetSocketAddress("localhost",6666));

        //发送
        client.send(packet);

        //释放
        client.close();
    }

    public static void clientSend(String filePath) throws IOException {
        System.out.println("正在发送...");
        DatagramSocket client = new DatagramSocket(8888);
        File file = new File(filePath);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] container = bis.readAllBytes();
        bis.close();
        DatagramPacket packet = new DatagramPacket(container, 0, container.length, new InetSocketAddress("localhost",6666));
        client.send(packet);
        client.close();
        System.out.println("发送完毕...");
    }
}
