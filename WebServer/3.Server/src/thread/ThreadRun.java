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
public class ThreadRun implements Runnable{

    private Socket client;
    private Request request;
    private Response response;
    private Servlet servlet;

    public ThreadRun(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            this.request = new Request(client);
            this.response = new Response(client);
            servlet = WebApp.getServletFromUrl(request.getUrl());
        } catch (IOException e) {
            System.out.println("响应出错...");
            e.printStackTrace();
        }
        if (servlet != null){
            servlet.service(request,response);
            response.pushToBrowser(200);
        }else {
            response.pushToBrowser(404);
        }
    }
}
