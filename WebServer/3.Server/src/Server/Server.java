package Server;

import servlet.Servlet;
import servlet.WebApp;
import thread.ThreadRun;

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
            new Thread(new ThreadRun(client)).start();

//            Request request = new Request(client);
//            Response response = new Response(client);
//

//            //通过WebApp 解析并动态创建Servlet
//            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
//            if (servlet != null){
//                servlet.service(request,response);
//                response.pushToBrowser(200);
//            }else {
//                response.pushToBrowser(404);
//            }
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
