package hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 学习HashSet的基本用法 与list类似 (有序不重复)
 * 底层实际是HashMap add时候只是添加key 所以不重复
 * @Author: Harlan
 * @Date: 2020/6/6 15:41
 */
public class TestHashSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("d");
        set.remove("d");
        System.out.println(set);
    }
}
