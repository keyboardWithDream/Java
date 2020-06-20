package Server;

import serlvet.LoginServlet;
import serlvet.RegisterServlet;
import serlvet.Servlet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 使用ServerSocket建立与浏览器的连接,获取请求协议
 * @Author: Harlan
 * @Date: 2020/6/20 15:20
 */
public class Server {

    private ServerSocket ss;
    private final String LOGIN = "login";
    private final String REGISTER = "reg";

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


            Request request = new Request(client);
            Response response = new Response(client);

            Servlet servlet = null;

            if (request.getUrl().equals(LOGIN)){
                servlet = new LoginServlet();
                servlet.service(request, response);
            }else if (request.getUrl().equals(REGISTER)){
                servlet = new RegisterServlet();
                servlet.service(request, response);
            }


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
