package sxtlinkedlink;

/**
 * 节点对象
 * @Author: Harlan
 * @Date: 2020/6/4 22:22
 */
public class Node<E> {

    /**
     * previous 上个节点
     * next 下个节点
     * element 元素数据
     */
    Node previous;
    Node next;
    E element;

    public Node(E element) {
        super();
        this.element = element;
    }

    public Node(Node previous, Node next, E element){
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }
}
