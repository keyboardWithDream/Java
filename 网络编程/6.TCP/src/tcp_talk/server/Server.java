package tcp_talk.server;

import tcp_talk.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 22:06
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);
        ClientsList clientsList = new ClientsList();
        System.out.println("====SERVER RUN====");

        while (true){
            Socket client = server.accept();
            System.out.println("====CLIENT ADD====");
            new Thread(new ThreadServer(client, clientsList)).start();
        }
    }
}
