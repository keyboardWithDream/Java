package iter;

import java.util.*;

/**
 * 迭代器遍历List / Set / Map
 * @Author: Harlan
 * @Date: 2020/6/6 16:22
 */
public class TestIterator {

    public static void main(String[] args) {
        testIteratorList();
        testIteratorMap();
    }

    /**
     * list 和 set 相同
     */
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        for (Map.Entry<Integer, String> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.toString());
        }
    }
}
