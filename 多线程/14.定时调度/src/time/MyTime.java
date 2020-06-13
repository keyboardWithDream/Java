package time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时调度: Timer类 和 TimerTask类
 * @Author: Harlan
 * @Date: 2020/6/13 19:42
 */
public class MyTime {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行安排
        MyTask myTask = new MyTask();
        timer.schedule(myTask, 5000,500);
    }
}

/**
 * 任务类
 */
class MyTask extends TimerTask{

    private int count;

    @Override
    public void run() {
        System.out.println("Hello world!"+ count + "次");
        count++;
    }
}
