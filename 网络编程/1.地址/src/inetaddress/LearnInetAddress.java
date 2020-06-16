package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP: 定位一个节点
 * InetAddress:
 * @Author: Harlan
 * @Date: 2020/6/15 22:51
 */
public class LearnInetAddress {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress addr = InetAddress.getLocalHost();

        assert addr != null;
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        System.out.println("===============");

        addr = InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        System.out.println("===============");

        addr = InetAddress.getByName("192.168.169.1");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
