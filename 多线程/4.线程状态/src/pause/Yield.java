package pause;

import jdk.swing.interop.SwingInterOpUtils;

/**
 * Yield
 * 礼让线程(释放锁),暂停线程 -直接进入就绪状态
 * @Author: Harlan
 * @Date: 2020/6/11 19:48
 */
public class Yield {

    public static void main(String[] args) {
       new Thread(()->{
           for (int i = 0; i < 100; i++) {
               System.out.println("线程-->"+i);
           }
       }).start();

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0){
                System.out.println("主线程礼让...");
                Thread.yield();
            }
            System.out.println("主线程-->"+i);
        }
    }
}
