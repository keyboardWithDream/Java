package string_method;

/**
 * String类 的常用方法
 * @author Harlna
 */
public class MethodOfString {

    public static void main(String[] args) {
        String str1 = "Hello World!";
        String str2 = "hello world!";

        //charAt(num) 捉取从0开始下标为num的字符
        System.out.println("charAt(6) :" + str1.charAt(6));

        //length()  返回字符串长度
        System.out.println("lenght() :" + str1.length());

        //equalsIgnoreCase(str) 忽略大小写比较相等
        System.out.println("equalsIgnoreCase() : "+ str1.equalsIgnoreCase(str2));

        //indexOf(str) 返回str第一次出现的位置
        System.out.println("indexOf(World) : " +str1.indexOf("World"));

        //replace('str' ,'str2') 替换
        System.out.println("replace(\" \" , \"! \") : " + str1.replace(" ","! "));

        //starsWith(str) 是否以 str 开头
        System.out.println("startWith(Hello) : "+str1.startsWith("Hello"));

        //endWith(str) 是否以 str 结尾
        System.out.println("endWith(!) : "+str1.endsWith("!"));

        //subString(num1,num2) 提取字符串:从下标为num1的开始到num2(不包括)
        System.out.println("subString(6) : "+str1.substring(6));
        System.out.println("subString(0,5) : "+str1.substring(0,5));

        //toLowerCase() 转小写 ,toUpperCase() 转大写
        System.out.println("toLowerCase() : " + str1.toLowerCase());
        System.out.println("toUpperCase() : " + str1.toUpperCase());

        //trim() 去除字符首位的空格(中间空格不能去)
        String str3 = "  Hello World !   ";
        System.out.println("trim() : " + str3.trim());
    }
}
