package sxthashmap;

import java.util.Arrays;

/**
 * 自定义HashMap
 * @Author: Harlan
 * @Date: 2020/6/6 10:02
 */
public class SxtHashMap<E, V> {
    /**
     * table: 位桶数组, bucket array
     * size: 存放键值对的个数
     */
    private Node[] table;
    private int size;

    /**
     *数组初始长度
     */
    public SxtHashMap() {
        //长度一般定义为2的整数幂
        table = new Node[16];
    }

    /**
     * 重写toString
     * 遍历数组和链表
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            while (temp != null){
                sb.append(temp.key + ":" + temp.value + ", ");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-2,'}');
        return sb.toString();
    }

    /**
     * 增加节点
     * @param key key值
     * @param value value值
     */
    public void put(E key, V value){
        //定义新节点对象
        int hash = myHash(key, table.length);
        Node newNode = new Node(hash, key, value, null);
        // 判断当前数组是否为空
        if (table[hash] == null){
            table[hash] = newNode;
            size++;
        }else {
            //遍历链表
            Node temp = table[hash];
            Node last = null;
            while (temp != null){
                //判断key是否重复
                if (temp.key.equals(key)){
                    //替换value值
                    temp.value = value;
                    break;
                }else {
                    last = temp;
                    temp = temp.next;
                }
            }
            //无重复添加到末尾
            if (temp == null){
                last.next = newNode;
                size++;
            }
        }
    }

    /**
     * hash算法
     * @param key 键
     * @param len 长度
     * @return 位置
     */
    public int myHash(E key, int len){
        return key.hashCode()&(len -1);
    }

    /**
     * 用key值查找
     * @param key key
     * @return 值
     */
    public Object getValue(E key){
        int index = myHash(key, table.length);
        Node temp = table[index];
        while (temp != null){
            if (temp.key.equals(key)){
                return temp.value;
            }else {
                temp = temp.next;
            }
        }
        return -1;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SxtHashMap<Integer, String> map = new SxtHashMap<>();
        map.put(10, "a");
        map.put(20, "b");
        map.put(30, "c");
        map.put(42, "a");
        map.put(42,"aa");
        System.out.println(map.toString());
        System.out.println(map.getValue(20));

        SxtHashMap<String,String> map1 = new SxtHashMap<>();
        map1.put("a","A");
        map1.put("b","B");
        map1.put("c","C");
        map1.put("c","c");
        System.out.println(map1.toString());
        System.out.println(map1.getValue("c"));
    }
}
