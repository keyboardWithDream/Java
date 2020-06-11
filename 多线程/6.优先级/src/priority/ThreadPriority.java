package priority;

/**
 * 线程的优先级 1-10
 * 1.NORM_PRIORITY  5 (默认所有)
 * 2.MIN_PRIORITY  1
 * 3.MAX_PRIORITY 10
 * 先后顺序是概率问题
 *
 * @Author: Harlan
 * @Date: 2020/6/11 23:21
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PriorityOfThread(),"t1");
        Thread t2 = new Thread(new PriorityOfThread(),"t2");
        Thread t3 = new Thread(new PriorityOfThread(),"t3");
        Thread t4 = new Thread(new PriorityOfThread(),"t4");
        Thread t5 = new Thread(new PriorityOfThread(),"t5");
        Thread t6 = new Thread(new PriorityOfThread(),"t6");

        //设置优先级必须在启动之前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.NORM_PRIORITY);
        t6.setPriority(Thread.NORM_PRIORITY);

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getPriority());
    }
}

class PriorityOfThread implements Runnable {

    @Override
    public void run() {
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getPriority());
    }
}