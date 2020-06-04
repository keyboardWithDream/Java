package my_arraylist;

import java.util.Arrays;

/**
 * 自定义实现一个ArrayList 体会底层原理
 * @Author: Harlan
 * @Date: 2020/6/4 15:45
 */
public class SxtArrayList<E> {

    private Object[] elementsData;
    private int size;
    private static final int DEALT_CAPACITY = 10;

    /**
     * 无参构造 默认长度10
     */
    public SxtArrayList(){
        elementsData = new Object[DEALT_CAPACITY];
    }

    /**
     * 单参构造
     * @param capacity 长度
     */
    public SxtArrayList(int capacity){
        if (capacity < 0){
            throw new RuntimeException("长度不合法!");
        }else if (capacity == 0){
            elementsData = new Object[DEALT_CAPACITY];
        }else {
            elementsData = new Object[capacity];
        }
    }

    /**
     * 添加元素 + 扩容
     * @param e 元素
     */
    public void add(E e){
        if (size == elementsData.length){
            Object[] elements = new Object[elementsData.length + (elementsData.length >> 1)];
            System.arraycopy(elementsData,0,elements,0,elementsData.length);
            elementsData = elements;
        }
        elementsData[size++] = e;
    }

    /**
     * 长度
     * @return 长度
     */
    public int getSize(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0 ? false : true;
    }

    /**
     * set 方法
     * @param index 索引
     * @param e 值
     */
    public void set(int index, E e){
        checkRange(index);
        elementsData[index] = e;;
    }

    /**
     * get 方法
     * @param index 索引
     * @return  索引处的值
     */
    public E get(int index){
       checkRange(index);
       return (E)elementsData[index];
    }

    /**
     * 移除
     * @param index 索引
     */
    public void remove(int index){
        checkRange(index);
        if (index < size){
            System.arraycopy(elementsData,index + 1,elementsData,index,size - (index+1));
        }
        elementsData[--size] = null;
    }

    /**
     * 复写移除
     * @param e 值
     */
    public void remove(E e){
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (elementsData[i].equals(e)){
                remove(i);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("不存在!");
        }
    }

    /**
     * 转成String类型
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementsData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    private void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("索引值不合法!");
        }
    }


    /**
     * 执行测试
     * @param args
     */
/*    public static void main(String[] args) {
        SxtArrayList<String> list = new SxtArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i+ "");
        }
        System.out.println(list.toString());
        System.out.println(list.getSize());
        list.set(0, "446");
        System.out.println(list);
        System.out.println(list.get(0));
        list.remove("446");
        System.out.println(list);
        System.out.println(list.getSize());
    }*/
}
