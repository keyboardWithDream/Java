package text_runnable;

/**
 * 模拟龟兔赛跑
 * @Author: Harlan
 * @Date: 2020/6/10 17:14
 */
public class Racer implements Runnable{

    private String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() +"--->"+ i);
            //模拟休息
            if (Thread.currentThread().getName() == "rabbit" && i == 10){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //比赛是否结束
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        if (winner != null){
            return true;
        }else {
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner --> "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer r = new Racer();
        new Thread(r,"Tortoise").start();
        new Thread(r,"rabbit").start();
    }
}
