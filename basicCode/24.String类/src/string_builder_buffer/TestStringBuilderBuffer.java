package string_builder_buffer;

/**
 * StringBuilder,Buffer - 可变的字符序列(没有final修饰)
 * @Author: Harlan
 * @Date: 2020/6/2 14:05
 */
public class TestStringBuilderBuffer {

    public static void main(String[] args) {

        /* StringBuilder 线程不安全,效率高(一般使用) */
        /* StringBuffer 线程安全,效率低 */
        StringBuilder sb = new StringBuilder("hello world!");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        System.out.println("改变过后:");

        sb.append(" Hello Harlan!");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
        System.out.println("================================");

        /* 常用方法 */

        /* 添加 */
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            strB.append((char)('a' + i));
        }
        System.out.println(strB);

        System.out.println("================================");
        /* 倒序 */
        strB.reverse();
        System.out.println("倒序 : "+strB);

        /* 链式调用插入 */
        System.out.println("================================");
        strB.insert(0,"我").insert(2,"是").insert(4,"谁");
        System.out.println(strB);

        /* 删除 */
        System.out.println("================================");
        strB.delete(0,5);
        System.out.println(strB);
    }
}
