package tcp_talk;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 20:34
 */
public class Send implements Runnable{

    private BufferedReader console;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;

    public Send(Socket client) {
        this.client = client;
        this.console = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
            this.dis = new DataInputStream(client.getInputStream());
            this.isRunning = true;
        } catch (IOException e) {
            System.out.println("客户端错误!");
            release();
        }
    }

    private String getMessage(){
        try {
            return console.readLine();
        } catch (IOException e) {
            System.out.println("getMessage错误!");
            release();
        }
        return null;
    }

    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("send -- 错误!");
            release();
        }
    }

    private void release(){
        this.isRunning = false;
        Utils.close(dis,dos,client);
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getMessage();
            if (!msg.equals("")){
                send(msg);
            }
        }
    }
}
