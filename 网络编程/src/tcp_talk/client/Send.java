package tcp_talk.client;

import tcp_talk.Utils;
import java.io.*;
import java.net.Socket;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:56
 */
public class Send implements Runnable{

    private Socket client;
    private DataOutputStream dos;
    private boolean isRunning;
    private BufferedReader console;
    private final String ERROR = "数据接收错误!";

    public Send(Socket client) {
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMessage(){
        String msg = ERROR;
        try {
            msg = console.readLine();
        } catch (IOException e) {
            getError();
        }
        return msg;
    }

    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            getError();
        }
    }

    /**
     * 异常处理
     */
    private void getError(){
        this.isRunning = false;
        System.out.println("###!!!WARNING!!!###");
        Utils.close(dos,client);
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = getMessage();
            send(msg);
        }
    }
}
