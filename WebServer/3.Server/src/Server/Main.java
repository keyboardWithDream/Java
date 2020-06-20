package Server;

/**
 * 主程序
 * @Author: Harlan
 * @Date: 2020/6/20 15:23
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        while (true){
            server.receive();
        }


    }
}
