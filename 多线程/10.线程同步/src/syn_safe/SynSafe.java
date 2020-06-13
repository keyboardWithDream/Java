package syn_safe;

/**
 * 线程同步(锁):在并发时保证数据的正确性,效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @Author: Harlan
 * @Date: 2020/6/12 16:06
 */
public class SynSafe {

    public static void main(String[] args) {

        SafeWbe12306 safeWbe12306 = new SafeWbe12306(100);
        //模拟延时
        safeWbe12306.flag = true;

        Thread t1 = new Thread(safeWbe12306,"t1");
        Thread t2 = new Thread(safeWbe12306,"t2");
        Thread t3 = new Thread(safeWbe12306,"t3");
        Thread t4 = new Thread(safeWbe12306,"t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SafeWbe12306 implements Runnable{

    private int ticketNum;
    boolean flag = true;

    public SafeWbe12306(int ticketNum) {
        this.ticketNum = ticketNum;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flag){
            isFlag();
        }
    }

    /**
     * 锁定 synchronized
     * 双重检测 (double checking) 零界值检测
     */
    public void isFlag(){
        //优化 --- 考虑有没有票
        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        //锁定当前对象
        synchronized (this) {
            //考虑最后的一张票
            if (ticketNum <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --- >" + ticketNum--);
        }
    }
}