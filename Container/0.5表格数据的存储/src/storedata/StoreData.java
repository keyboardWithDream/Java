package storedata;

import java.util.*;

/**
 * 表格数据的存储
 * ORM思想: 对象关系映射
 * 用list + map 举例
 * @Author: Harlan
 * @Date: 2020/6/6 17:09
 */
public class StoreData {
    public static void main(String[] args) {

        //第一行
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id","1001");
        row1.put("name","harlan");
        row1.put("age","23");
        row1.put("salary",20000);
        row1.put("入职日期","2020.6.6");
        //第二行
        Map<String, Object> row2 = new HashMap<>();
        row2.put("id","1002");
        row2.put("name","李四");
        row2.put("age","30");
        row2.put("salary",30000);
        row2.put("入职日期","2020.3.6");
        //第三行
        Map<String, Object> row3 = new HashMap<>();
        row3.put("id","1003");
        row3.put("name","王五");
        row3.put("age","44");
        row3.put("salary",10000);
        row3.put("入职日期","2019.1.6");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        for (Map<String, Object> rows : list) {
            for (String key : rows.keySet()) {
                System.out.print(key+":"+rows.get(key)+ " ");
            }
            System.out.println();
        }
    }
}
