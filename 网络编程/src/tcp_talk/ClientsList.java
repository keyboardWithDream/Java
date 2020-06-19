package tcp_talk;

import tcp_talk.server.ThreadServer;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 23:41
 */
public class ClientsList {

    private CopyOnWriteArrayList<ThreadServer> allClients = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<ThreadServer> getAllClients() {
        return allClients;
    }
}
