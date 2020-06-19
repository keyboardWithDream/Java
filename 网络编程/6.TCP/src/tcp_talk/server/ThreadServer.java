package tcp_talk.server;

import tcp_talk.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:21
 */
public class ThreadServer implements Runnable{

    private Socket client;
    private DataOutputStream dos;
    private DataInputStream dis;
    private boolean isRunning;
    private ClientsList clientsList;
    private String name;
    private final String ONE_PERSON_ = "@";
    private final String ERROR = "数据接收错误!";

    public ThreadServer(Socket client, ClientsList clientsList) {
        this.client = client;
        try {
            this.dis = new DataInputStream(client.getInputStream());
            this.dos = new DataOutputStream(client.getOutputStream());
            isRunning = true;
            this.clientsList = clientsList;
            this.clientsList.getAllClients().add(this);
            this.name = receiveMsg();
            this.sendMsg("===欢迎"+this.name+"登陆===");
            this.sendOther("==="+this.name+"已上线===", true);
        } catch (IOException e) {
            getError();
        }
    }

    /**
     * 消息接收
     * @return 消息
     */
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
     * 消息发送
     * @param msg 消息
     */
    private void sendMsg(String msg){
        try {
            dos.writeUTF(this.name+": "+msg);
            dos.flush();
        } catch (IOException e) {
            getError();
        }
    }

    /**
     * 群发
     * 私聊 : @***:msg
     */
    private void sendOther(String msg, boolean isSystemMsg){
        if (msg.startsWith(ONE_PERSON_)){
            int index = msg.indexOf(":");
            String targetName = msg.substring(1,index);
            String targetMsg = msg.substring(index+1);
            for (ThreadServer ts : clientsList.getAllClients()) {
                if (ts.name.equals(targetName)) {
                    sendMsg(targetMsg);
                }
            }
        }else {
            for (ThreadServer ts : clientsList.getAllClients()) {
                if (ts == this){
                    continue;
                }else {
                    if (isSystemMsg){
                        ts.sendMsg(msg);
                    }else {
                        ts.sendMsg(this.name+ "对所有人说: "+msg);
                    }
                }
            }
        }
    }

    /**
     * 异常处理
     */
    private void getError(){
        this.isRunning = false;
        clientsList.getAllClients().remove(this);
        sendOther("==="+this.name+"已下线===",true);
        System.out.println("###!!!WARNING!!!###");
        Utils.close(dis,dos,client);
    }

    /**
     * 线程体
     */
    @Override
    public void run() {
        while (isRunning){
            String msg = receiveMsg();
            sendOther(msg,false);
        }
    }
}
