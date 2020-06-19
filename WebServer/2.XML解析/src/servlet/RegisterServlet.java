package servlet;

/**
 * @Author: Harlan
 * @Date: 2020/6/19 22:23
 */
public class RegisterServlet implements Servlet{

    public RegisterServlet() {
    }

    @Override
    public void service() {
        System.out.println("=====RegisterServlet=====");
    }
}
