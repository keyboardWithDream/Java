package servlet;

/**
 * @Author: Harlan
 * @Date: 2020/6/19 22:21
 */
public class LoginServlet implements Servlet{

    public LoginServlet() {
    }

    @Override
    public void service() {
        System.out.println("=====LoginServlet======");
    }
}
