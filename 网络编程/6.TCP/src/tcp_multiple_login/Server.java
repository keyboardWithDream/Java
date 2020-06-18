package tcp_multiple_login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 14:28
 */
public class Server {

    public static void main(String[] args)  {

        System.out.println("=====Server Run=====");

        //关闭服务器
        AtomicBoolean flag = new AtomicBoolean(true);
        final String SHUT_DOWN = "yes";

        new Thread(()->{
            System.out.print("是否关闭服务器: ");
            if (new Scanner(System.in).next().equals(SHUT_DOWN)){
                System.out.println("下一个用户登陆后关闭...");
                flag.set(false);
            }
        }).start();

        //连接客户端利用Socket创建输入流并接收数据
        ServerSocket server = null;
        Socket client = null;
        //统计第几个用户登录
        int count = 1;

        try {
            //这个必须放在while循环外面，否则会报端口占用的错误
            server = new ServerSocket(8777);
            while(flag.get()) {
                client = server.accept();

                /*
                 * 每次有用户登入，则为该用户创建一个线程，启动该线程来验证用户的登录是否成功
                 */
                new Thread(new LoginThread(client)).start();
                System.out.println("第"+(count++)+"个用户在访问，IP-->"+client.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("=====Server ShutDown=====");
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
         * 服务器要一直运行，所以不用关闭网络资源
         */
    }

}

