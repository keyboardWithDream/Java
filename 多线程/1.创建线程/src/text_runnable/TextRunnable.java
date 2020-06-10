package text_runnable;

/**
 * 共享资源,并发(需要保证线程安全)
 * @Author: Harlan
 * @Date: 2020/6/10 17:03
 */
public class TextRunnable implements Runnable{
    //票数
    private int ticketNum = 99;
    @Override
    public void run() {
        while (true){
            if (ticketNum < 0){
                break;
            }
            //模拟网络延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNum--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        TextRunnable tr = new TextRunnable();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(tr,"r1").start();
        new Thread(tr,"r2").start();
        new Thread(tr,"r3").start();


    }
}
