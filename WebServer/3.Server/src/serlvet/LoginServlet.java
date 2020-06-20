package serlvet;

import Server.Request;
import Server.Response;

/**
 * @Author: Harlan
 * @Date: 2020/6/19 22:21
 */
public class LoginServlet implements Servlet{

    public LoginServlet() {
    }

    @Override
    public void service(Request request, Response response) {
        System.out.println("Login响应成功...");
        response.print("<html lang=\"zh-CN\">");
        response.print("<head>");
        response.print("<title>");
        response.print("服务器响应成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("<h1>Login</h1>");
        response.print("服务器响应成功...<br>");
        response.print("name --->" + request.getParameterValue("uName") +"<br>");
        response.print("pwd ---> " +request.getParameterValue("pwd")+"<br>");
        response.print("</body>");
        response.print("</html>");
    }
}
