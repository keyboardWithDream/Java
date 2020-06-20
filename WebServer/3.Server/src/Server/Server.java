package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标: 使用ServerSocket建立与浏览器的连接,获取请求协议
 * @Author: Harlan
 * @Date: 2020/6/20 15:20
 */
public class Server {

    private ServerSocket ss;

    /**
     * 启动服务
     */
    public void start(){
        try {
            ss = new ServerSocket(8899);
            System.out.println("=====服务器启动成功=====");
        } catch (IOException e) {
            System.out.println("=====服务器启动失败=====");
            e.printStackTrace();
        }
    }

    /**
     * 接收连接处理
     */
    public void receive(){
        try {
            Socket client = ss.accept();
            System.out.println("=====一个客户端建立了连接=====");

            //获取请求协议
            InputStream is = client.getInputStream();
            byte[] data = new byte[1024 * 1024];
            int dataLen = is.read(data);
            System.out.println(new String(data,0,dataLen-1));
            System.out.println("==========================");

            //返回响应协议
            //响应内容
            Response response = new Response(client);
            StringBuilder content = new StringBuilder();
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("服务器响应成功...");
            response.print("</body>");
            response.print("</html>");

            //构建响应
            response.pushToBrowser(200);
        } catch (IOException e) {
            System.out.println("=====客户端连接错误=====");
            e.printStackTrace();
        }
    }

    /**
     * 停止服务
     */
    public void stop(){

    }
}
