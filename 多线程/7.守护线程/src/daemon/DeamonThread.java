package daemon;

/**
 * 守护线程: 是为用户线程服务的,jvm停止不用等待守护线程执行完毕
 * 默认:用户线程jvm等待用户线程执行完毕才会停止
 *
 * @Author: Harlan
 * @Date: 2020/6/11 23:37
 */
public class DeamonThread {

    public static void main(String[] args) {
        ThreadUser user = new ThreadUser();
        ThreadDeamon deamon = new ThreadDeamon();

        //线程默认为用户线程,手动调整为守护线程
        Thread daemon = new Thread(deamon);
        daemon.setDaemon(true);

        //启动线程
        daemon.start();
        new Thread(user).start();

    }
}


class ThreadUser extends Thread{

    @Override
    public void run(){
        for (int i = 1; i < 10; i++) {
            System.out.println("用户线程正在执行...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("!!!用户线程执行完毕!!!");
    }
}

class ThreadDeamon implements Runnable{

    @Override
    public void run(){
        while (true){
            System.out.println("守护线程正在执行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}