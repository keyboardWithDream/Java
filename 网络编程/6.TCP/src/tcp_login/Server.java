package tcp_login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 12:24
 */
public class Server implements Runnable{
    private final ServerSocket server;
    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;
    private final String PWD = "123456";
    private final String USERNAME = "admin";
    private String[] dataArray;
    private String cUserName;
    private String cPwd;

    public Server(int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            System.out.println("=====Server=====");
            client = server.accept();
            dis = new DataInputStream(client.getInputStream());
            String data = dis.readUTF();
            dataArray = data.split("&");
            for (String s : dataArray) {
                String[] userInfo = s.split("=");
                if (userInfo[1].equals(USERNAME)){
                    cUserName = userInfo[1];
                    System.out.println("正在尝试登陆...");
                }else if (userInfo[1].equals(PWD)){
                    cPwd = userInfo[1];
                    System.out.println("正在验证密码...");
                }
            }
            dos = new DataOutputStream(client.getOutputStream());
            if (cUserName.equals(USERNAME) && cPwd.equals(PWD)){
                dos.writeUTF("登陆成功...");
                System.out.println("登陆成功...");
            }else {
                dos.writeUTF("用户名或密码错误...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
