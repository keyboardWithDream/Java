package vector;

import java.util.Vector;

/**
 * Vector 是用数组实现的List, 线程安全,效率低
 * 因而安全索引添加了线程标记: synchronized 标记
 * @Author: Harlan
 * @Date: 2020/6/5 16:30
 */
public class TestVector {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        System.out.println(vector.get(0).toString());
    }
}
