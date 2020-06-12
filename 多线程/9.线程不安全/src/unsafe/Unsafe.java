package unsafe;

/**
 * 线程不安全:数据有负数和相同情况
 * @Author: Harlan
 * @Date: 2020/6/12 14:24
 */
public class Unsafe {

    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread t1 = new Thread(web12306,"t1");
        Thread t2 = new Thread(web12306,"t2");
        Thread t3 = new Thread(web12306,"t3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Web12306 implements Runnable{

    private int ticketsNum = 100;

    @Override
    public void run() {
        for ( ; ticketsNum >= 0; ticketsNum--) {
            if (ticketsNum % 5 == 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->"+ ticketsNum);
        }
    }
}
