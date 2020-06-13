package container;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全: 操作并发容器 (CopyOnWriteArrayList)
 * @Author: Harlan
 * @Date: 2020/6/13 14:13
 */
public class SynContainer {
    public static void main(String[] args) {
        //已加锁容器
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int num = i;
            new Thread(()->{
                System.out.println(num);
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
