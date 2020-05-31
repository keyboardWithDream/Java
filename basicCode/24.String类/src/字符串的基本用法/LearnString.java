package 字符串的基本用法;

/**
 * String 字符串类的基本用法
 * @author Harlan
 */
public class LearnString {

    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("def");
        String str3 = str + str2;
        String str4 = "19" + 97;
        System.out.printf("%s %s %s %s\n", str, str2, str3,str4);

        System.out.println("========================");

        //存放于常量池
        String str10 = "harlan";
        String str11 = "harlan";

        //字符串对象
        String str12 = new String("harlan");

        System.out.println("str10 与 str11 是否为同一对象: " + str10 == str11);
        System.out.println("str10 与 str12 是否为同一对象: " + str10 == str12);

        //通常比较字符串时,使用equals 直接比较内容
        System.out.println(str10.equals(str11));
        System.out.println(str10.equals(str12));
    }
}
