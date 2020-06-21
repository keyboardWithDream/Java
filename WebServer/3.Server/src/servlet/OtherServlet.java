package servlet;

import Server.Request;
import Server.Response;

/**
 * @Author: Harlan
 * @Date: 2020/6/21 0:53
 */
public class OtherServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        System.out.println("测试页面响应成功...");
        response.print("<h1>这是一个测试页面...</h1>");
    }
}
