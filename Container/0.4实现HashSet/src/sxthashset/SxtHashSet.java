package sxthashset;

import java.util.HashMap;

/**
 * 实现HashSet
 * @Author: Harlan
 * @Date: 2020/6/6 15:50
 */
public class SxtHashSet<E> {

     HashMap map;
     private  static final Object PRESENT = new Object();

     public SxtHashSet(){
         map = new HashMap();
     }

     public int size(){
         return map.size();
     }

     public void add(E e){
         map.put(e, PRESENT);
     }

    @Override
    public String toString() {
        return "SxtHashSet{" +
                "map=" + map.keySet() +
                '}';
    }

    public static void main(String[] args) {
        SxtHashSet<String> set = new SxtHashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println(set.toString());
    }
}
