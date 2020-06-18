package tcp_multiple_login;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 15:35
 */
public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("=====Client Run=====");

        //提醒并接收用户输入
        Scanner sc = new Scanner(System.in);
        System.out.print("用户名: ");
        String name = sc.next();
        System.out.print("密码: ");
        String password = sc.next();

        //连接服务器利用Socket创建输出流,能将对象输出到服务器
        Socket client = new Socket("localhost",8777);
        OutputStream os = client.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(new User(name, password));

        //关闭输出流
        client.shutdownOutput();

        //利用Socket创建输入流接收服务器验证信息
        InputStream is = client.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readUTF());

        //关闭
        dis.close();
        is.close();
        client.close();
    }
}
