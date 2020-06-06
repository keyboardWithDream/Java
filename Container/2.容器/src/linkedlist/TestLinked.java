package linkedlist;

import java.util.LinkedList;

/**
 * LinkedList 特点: 1.查询效率低 2.增删效率高 3.线程不安全
 * @Author: Harlan
 * @Date: 2020/6/4 21:48
 */
public class TestLinked {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        System.out.println(linkedList.get(0).toString());
    }
}
