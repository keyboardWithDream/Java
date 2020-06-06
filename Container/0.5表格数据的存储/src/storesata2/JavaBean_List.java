package storesata2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路: JavaBean + List 存储表格
 * @Author: Harlan
 * @Date: 2020/6/6 18:39
 */
public class JavaBean_List {
    public static void main(String[] args) {
        User user1 = new User(1001,"张三", 10000, "2018.5.5");
        User user2 = new User(1002,"李四", 50000, "2020.3.8");
        User user3 = new User(1003,"王五", 6000, "2012.1.10");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        for (User user : list) {
            System.out.println(user.toString());
        }

        System.out.println("========================");

        Map<Integer, User> map = new HashMap<>();
        map.put(user1.getId(),user1);
        map.put(user2.getId(),user2);
        map.put(user3.getId(),user3);

        for (Integer rows : map.keySet()) {
            System.out.println(map.get(rows).toString());
        }
    }
}
