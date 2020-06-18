package tcp_login;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 12:24
 */
public class Client implements Runnable{
    private final Socket client;
    private DataOutputStream dos;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    private final Scanner scanner = new Scanner(System.in);
    private DataInputStream dis;
    private String username;
    private String pwd;

    public Client(String hostname, int port) throws IOException {
        this.client = new Socket(hostname, port);
    }

    @Override
    public void run() {
        try {
            System.out.println("=====Client=====");
            System.out.print("请输入用户名: ");
            username = br.readLine();
            System.out.print("\n请输入密码: ");
            pwd = br.readLine();
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF("username="+username+ "&pwd=" + pwd);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dos != null){
                try {
                    dos.close();
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
