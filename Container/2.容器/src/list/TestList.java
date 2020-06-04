package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 接口:
 * 父接口为 Collection
 * 实现类为:ArrayList LinkedList Vector
 * List 特点: 1.有序 2.重复 3.速度块 4.插入删除慢 5.线程不安全
 * @Author: Harlan
 * @Date: 2020/6/4 14:58
 */
public class TestList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("C");
        list.add("hello");
        list.add("D");
        System.out.println(list);

        //在index 添加
        list.add(1,"B");
        System.out.println(list);

        //在index 修改
        list.set(3,"D");
        System.out.println(list);

        //在index 移除
        list.remove(4);
        System.out.println(list);

        //获取 index元素
        System.out.println(list.get(0));

        list.add(0,"D");
        //返回元素第一次出现的index (不存在返回-1)
        System.out.println(list.indexOf("D"));
        //返回最后出现的位置
        System.out.println(list.lastIndexOf("D"));
    }
}
