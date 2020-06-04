package my_arraylist;

/**
 * 测试SxtArrayList
 * @Author: Harlan
 * @Date: 2020/6/4 18:54
 */
public class TestArrayList {

    public static void main(String[] args) {
        SxtArrayList<Character> list = new SxtArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
        }

        System.out.println(list);
        list.add('A');
        System.out.println(list);
    }
}
