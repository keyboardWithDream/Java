package sxthashmap;

/**
 * HashMap 的节点
 * @Author: Harlan
 * @Date: 2020/6/6 10:03
 */
public class Node<E, V> {
    int hash;
    E key;
    V value;
    Node next;

    public Node(int hash, E key, V value, Node next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
