package stop;

/**
 * 线程停止状态
 * 利用变量控制实现线程的结束(不要使用stop方法)
 * 1.线程正常执行完毕 --> 次数
 * 2.外部干涉 --> 加入标识
 * @Author: Harlan
 * @Date: 2020/6/11 16:08
 */

import java.util.Date;

/**
 * 线程类
 */
class ThreadTest implements Runnable{

    /**
     * 加入标识(标记是否可以运行)
     */
    private Boolean flag = true;

    public void terminate() {
        this.flag = false;
        System.out.println("线程已被终止...");
    }

    @Override
    public void run() {
        int count = 1;
        //线程终止条件
        while (this.flag){
            System.out.println("线程正在运行中...("+(count++)+"次)");
        }
    }
}

/**
 * 主类
 */
public class ThreadStop {

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        //启动线程(新生状态).start(就绪状态)
        new Thread(tt).start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" ---> "+ i);
            if (i == 50){
                //终止线程(死亡状态)
                tt.terminate();
            }
        }
    }
}
