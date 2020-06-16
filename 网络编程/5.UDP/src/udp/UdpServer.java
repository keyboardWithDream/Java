package udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * 接收端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramSocket 包裹
 * 3.阻塞式接受包裹 receive(DatagramPacket p)
 * 4.分析数据
 *  byte[] getData()
 *         getLength()
 * 5.释放资源
 * @Author: Harlan
 * @Date: 2020/6/16 17:24
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        serverReceive("./5.UDP/src/img/receive.jpg");
    }

    public void receiveMessage() throws IOException {
        System.out.println("准备接收数据...");

        //创建接收端 指定端口
        DatagramSocket server = new DatagramSocket(6666);

        //准备容器(不能太大)
        byte[] container = new byte[1024 * 60];

        //将容器封装
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        //阻塞式接收
        server.receive(packet);

        //分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();

        //释放
        server.close();

        System.out.println("数据为: "+ new String(data) + " 长度为: " + len);
    }

    public static void serverReceive(String filePath) throws IOException {
        System.out.println("准备接收...");
        DatagramSocket server = new DatagramSocket(6666);
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length );
        server.receive(packet);
        byte[] data = packet.getData();
        File file = new File(filePath);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(data,0,data.length);
        bos.flush();
        bos.close();
        server.close();
        System.out.println("接收完毕...");
    }
}
