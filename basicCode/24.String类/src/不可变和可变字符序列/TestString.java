package 不可变和可变字符序列;

/**
 * 字符串是不可变序列  其核心是 private final char value[];
 * 字符串用equals()比较
 *
 * @Author: Harlan
 * @Date: 2020/6/2 13:55
 */
public class TestString {

    public static void main(String[] args) {
        String str = "hello java";
        /* 编译器做了优化 直接在编译的时候将字符串进行拼接后赋值 */
        String str1 = "hello " + "java";
        /* 同一个对象 结果为true */
        System.out.println(str == str1);

        /* 编译的时候不知道变量中存储的是什么,所以没办法在编译的时候优化 */
        String str2 = "hello ";
        String str3 = "world";
        String str4 = str2 + str3;
        System.out.println(str4 == str);
    }
}