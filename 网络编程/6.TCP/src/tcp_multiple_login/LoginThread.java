package tcp_multiple_login;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 13:55
 */
public class LoginThread implements Runnable {
    private InputStream is = null;
    private ObjectInputStream ois = null;
    private final Socket client;

    public LoginThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            //通过Socket对象拿到输入流
            is = client.getInputStream();
            ois = new ObjectInputStream(is);
            User p = (User) ois.readObject();

            //关闭Socket输入流
            client.shutdownInput();

            //启动Socket输出流，将登陆成功或失败信息返回给客户端
            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            //对接收到的数据进行判定
            final String USER_NAME = "admin";
            final String PASSWORD = "123456";
            if(USER_NAME.equals(p.getName()) && PASSWORD.equals(p.getPassword())) {
                dos.writeUTF("登陆成功！");
            }else {
                dos.writeUTF("登陆失败！");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            //关流
            try {
                client.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}