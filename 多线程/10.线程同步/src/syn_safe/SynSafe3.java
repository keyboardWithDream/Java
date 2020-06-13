package syn_safe;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全: 操作容器
 * @Author: Harlan
 * @Date: 2020/6/13 12:05
 */
public class SynSafe3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //锁定list
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
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
