package method_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 接口:            Collection
 * 子接口:      List          Set
 * 实现类:    ArrayList
 *
 * 学习Collection接口中的方法
 * List,Set方法的都将于实现类实现
 *
 * @Author: Harlan
 * @Date: 2020/6/3 17:08
 */
public class TestCollection {

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 常用方法1
     */
    static void test1(){
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        //添加
        c.add("harlan");
        c.add("hello");
        System.out.println(c);

        //转出Object数组
        Object[] objs = c.toArray();
        System.out.println(Arrays.toString(objs));

        //是否包含某个元素
        System.out.println(c.contains("harlan"));

        //移除(对象还在)
        c.remove("harlan");
        System.out.println(c);

        //清空(清空容器,对象还在)
        c.clear();
        System.out.println(c);
    }


    /**
     * 常用方法2
     * 集合类(并集,交集)
     */
    static void test2(){
        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");

        List<String> list2 = new ArrayList<>();
        list1.add("aa");
        list2.add("dd");
        list2.add("ee");

        list1.addAll(list2);
        System.out.println(list1);
        list1.removeAll(list2);
        System.out.println(list1);
        list1.retainAll(list2);
        System.out.println(list1);
    }
}
