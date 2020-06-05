package sxtlinkedlink;

/**
 * 实现LinkedList
 * 特点: 1.查询效率低 2.增删效率高 3.线程不安全
 * @Author: Harlan
 * @Date: 2020/6/4 22:22
 */
public class SxtLinkedList<E> {

    /**
     * first 第一个节点
     * last 最后一个节点
     * size 节点个数
     */
    private Node first;
    private Node last;
    private int size;

    /**
     * 增加节点
     * @param obj 增加的节点
     */
    public void add(E obj){
        Node node = new Node(obj);
        //判断是否为第一个节点
        if (first == null){
            //设为第一个节点
            first = node;
        }else {
            //上一个节点的尾部等于下一个节点
            last.next = node;
            //当前节点的头部等于上一个节点
            node.previous = last;
            //当前节点为最后一个节点,下一个节点为空
            node.next = null;
        }
        //设为最后一个节点
        last = node;
        size++;
    }


    /**
     * 插入节点
     * @param index 索引
     * @param e 泛型
     */
    public void  add(int index,E e){
        Node node = new Node(e);
        Node temp;
        int count;
        throwException(index);
        if (index == 0){
            first.previous = node;
            node.next = first;
            first = node;
        }else if (index == size - 1){
            node.previous = last.previous;
            last.previous.next = node;
            node.next = last;
            last.next = null;
        }else if (index < size >> 1){
            temp = first;
            count = 0;
            while (count < index){
                temp = temp.next;
                count++;
            }
            temp.previous.next = node;
            node.previous = temp.previous;
            node.next = temp;
            temp.previous = node;
        } else {
            temp = last;
            count = size - 1;
            while (count > index) {
                temp = temp.previous;
                count--;
            }
            temp.previous.next = node;
            node.previous = temp.previous;
            node.next = temp;
            temp.previous = node;
        }
    }

    /**
     * 二分法查找
     * @param index 索引
     * @return 值
     */
    public Object getNode(int index){
        throwException(index);
        Node temp;
        int count;
        if (index < size >> 1){
            temp = first;
            count = 0;
            while (count < index){
                temp = temp.next;
                count++;
            }
        }else {
            temp = last;
            count = size - 1;
            while (count > index){
                temp = temp.previous;
                count--;
            }
        }
        return (E)temp.element;
    }

    /**
     * 删除接点
     * @param index 索引
     */
    public void remove(int index){
        throwException(index);
        Node temp = null;
        int count;
        if (index == 0){
            first = first.next;
            first.previous = null;
        }else if (index == size - 1){
            last = last.previous;
            last.next = null;
        } else if (index < size >> 1){
            temp = first;
            count = 0;
            while (count < index){
                temp = temp.next;
                count++;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
        } else {
            temp = last;
            count = size - 1;
            while (count > index){
                temp = temp.previous;
                count--;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
        }
        size--;
    }

    /**
     * 输出String
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder allNode = new StringBuilder("[");
        Node temp = first;
        while (temp.next != null){
            allNode.append((E)temp.element.toString()+", ");
            temp = temp.next;
        }
        allNode.append(temp.element.toString()+"]");
        return allNode.toString();
    }

    /**
     * 索引异常方法
     * @param index 索引
     */
    private void throwException(int index){
        if (index >= size || index < 0){
            throw new RuntimeException("超出索引范围!");
        }
    }

    /**
     * 测试功能
     * @param args
     */
    public static void main(String[] args) {
        SxtLinkedList linkedList = new SxtLinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add(5,"hhn");
        System.out.println(linkedList.toString());
    }
}
