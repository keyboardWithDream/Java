package join;

/**
 * join (成员方法) 线程插队(合并线程)-阻塞其它线程
 * @Author: Harlan
 * @Date: 2020/6/11 20:36
 */
public class  JoinThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("线程正在执行..." + i);
            }
        });
        t.start();

        for (int i = 0; i < 100; i++) {
            if (i == 30){
                try {
                    //线程插入,main线程被阻塞了
                    System.out.println("线程插入...");
                    t.join();
                    System.out.println("线程执行完毕...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主程序正在执行..."+i);
        }
    }
}
