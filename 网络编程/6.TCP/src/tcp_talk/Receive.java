package tcp_talk;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 20:35
 */
public class Receive implements Runnable{

    private Socket client;
    private DataInputStream dis;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        try {
            this.dis = new DataInputStream(client.getInputStream());
            this.isRunning = true;
        } catch (IOException e) {
            System.out.println("客户端错误!");
            release();
        }
    }

    private String receive(){
        String msg = "消息接收失败!";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("receive -- 错误!");
            release();
        }
        return msg;
    }

    private void release(){
        this.isRunning = false;
        Utils.close(dis,client);
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if (!msg.equals("消息接收失败!")){
                System.out.println(msg);
            }
        }
    }
}
