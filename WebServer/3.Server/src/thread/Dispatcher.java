package thread;

import Server.Request;
import Server.Response;
import servlet.Servlet;
import servlet.WebApp;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/21 1:06
 */
public class Dispatcher implements Runnable{

    private Socket client;
    private Request request;
    private Response response;
    private Servlet servlet;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            this.request = new Request(client);
            this.response = new Response(client);
        } catch (IOException e) {
            System.out.println("响应出错...");
            release();
            e.printStackTrace();
        }
    }

    /**
     * 关闭客户端,释放资源
     */
    private void release(){
        try {
            client.close();
        } catch (IOException e) {
            System.out.println("=====客户端关闭异常=====");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("客户端IP: " + client.getLocalAddress().getHostAddress());
        servlet = WebApp.getServletFromUrl(request.getUrl());
        if (servlet != null){
            servlet.service(request,response);
            response.pushToBrowser(200);
        }else {
            response.pushToBrowser(404);
        }
        //短连接 释放资源
        release();
    }
}
