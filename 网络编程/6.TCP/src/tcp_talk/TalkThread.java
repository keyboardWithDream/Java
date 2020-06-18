package tcp_talk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 17:53
 */
public class TalkThread implements Runnable{

    private DataOutputStream dos;
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning;
    private CopyOnWriteArrayList<TalkThread> all = new CopyOnWriteArrayList<>();

    public TalkThread(Socket client) {
        this.client = client;
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
            this.dis = new DataInputStream(client.getInputStream());
            isRunning = true;
            all.add(this);
        } catch (IOException e) {
            System.out.println("TalkThread -- 错误!");
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

    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("send -- 错误!");
            release();
        }
    }

    private void sendOther(String msg){
        for (TalkThread talkThread : all) {
            if (talkThread == this){
                continue;
            }else {
                talkThread.send(msg);
            }
        }
    }

    private void release(){
        this.isRunning = false;
        Utils.close(dis,dos,client);
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if (!msg.equals("消息接收失败!")){
                sendOther(msg);
            }
        }
    }
}
