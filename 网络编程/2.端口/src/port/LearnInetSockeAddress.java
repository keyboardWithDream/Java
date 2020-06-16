package port;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1.区分软件
 * 2.两个字节 0-65536 UDP/TCP
 * 3.同一个协议端口不能冲突
 * 4.定义端口越大越好
 *
 * InetSockeAddress
 * 1.构造器 new InetSocketAddress(域名,端口)
 * 2.方法 getAddress(), getPort(), getHostName()
 * @Author: Harlan
 * @Date: 2020/6/16 14:31
 */
public class LearnInetSockeAddress {

    public static void main(String[] args) {
        InetSocketAddress socketAddress1 = new InetSocketAddress("127.0.0.1",8080 );
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress1.getHostName());
        System.out.println(socketAddress1.getPort());

        System.out.println("===================");

        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",8080 );
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getHostName());
        System.out.println(socketAddress2.getPort());
    }
}
