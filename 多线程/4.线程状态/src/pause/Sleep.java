package pause;

/**
 * 线程阻塞状态(sleep)
 * 每个对象都有一个锁,sleep不会释放锁
 * sleep:放大发生错误的可能性
 * sleep:模拟网络延迟
 * @Author: Harlan
 * @Date: 2020/6/11 18:48
 */

class Tickets implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket <= 1){
                break;
            }
            try {
                //阻塞(暂停) 放大发生错误的可能性
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " -- 抢到了第" + this.ticket-- +" 张票");
        }
    }
}

/**
 * 主线程程序
 */
public class Sleep {

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(tickets,"t1").start();
        new Thread(tickets, "t2").start();
        new Thread(tickets, "t3").start();
    }
}
