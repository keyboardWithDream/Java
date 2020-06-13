package deadlock;

import java.io.File;

/**
 * 死锁: 过多的同步可能会造成相互不释放资源
 * 从而相互等待,一般发生于同步中持有多个对象的锁
 * 避免:不要在同一个代码块中 同时持有多个资源的锁
 *
 * @Author: Harlan
 * @Date: 2020/6/13 14:47
 */
public class DeadLock {

    public static void main(String[] args) {
        User user1 = new User(1,"User1");
        User user2 = new User(0,"User2");
        user1.start();
        user2.start();
    }
}

/**
 * 资源1
 */
class First {
    public void print(String name){
        System.out.println(name+" 正在获取资源1...");
    }
}

/**
 * 资源2
 */
class Second {
    public void print(String name){
        System.out.println(name+" 正在获取资源2...");
    }
}

class User extends Thread{
    private int choice;
    private String name;
    private static First first = new First();
    private static  Second second = new Second();

    public User(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    /**
     * 获取资源
     * 相互持有对方的对象锁--->可能造成死锁
     */
    private void getRec(){
        if (choice == 0){
            synchronized (first){
                first.print(name);
                //之后获得second 的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (second){
                    second.print(name);
                }
            }
        }else {
            synchronized (second){
                second.print(name);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (first){
                    first.print(name);
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();
        getRec();
    }
}