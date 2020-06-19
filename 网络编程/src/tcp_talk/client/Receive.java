package tcp_talk.client;

import tcp_talk.Utils;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:46
 */
public class Receive implements Runnable{

    private Socket client;
    private DataOutputStream dos;
    private DataInputStream dis;
    private boolean isRunning;
    private final String ERROR = "数据接收错误!";

    public Receive(Socket client) {
        this.client = client;
        try {
            this.dis = new DataInputStream(client.getInputStream());
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String receiveMsg(){
        String msg = ERROR;
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            getError();
        }
        return msg;
    }

    /**
     * 异常处理
     */
    private void getError(){
        this.isRunning = false;
        System.out.println("###!!!WARNING!!!###");
        Utils.close(dis,client);
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = receiveMsg();
            System.out.println(msg);
        }
    }
}
