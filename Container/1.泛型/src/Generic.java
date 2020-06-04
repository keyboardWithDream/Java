import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 在类的声明处增加泛型列表,<T, E, V>
 * @Author: Harlan
 * @Date: 2020/6/3 16:47
 */
public class Generic {

    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<String>();

        collection.set("harlan", 0);
        collection.set("23", 1);
        collection.set("446", 2);
        String print = collection.get(0) + collection.get(1) + collection.get(2);
        System.out.println(print);

        List<String> list = new ArrayList<>();
    }
}


/**
 * 编写泛型
 * @param <E> 泛型
 */
class MyCollection<E> {
    Object[] objs = new Object[5];

    public void set(E e,int index){
        objs[index] = e;
    }

    public E get(int index){
        return (E)objs[index];
    }
}
