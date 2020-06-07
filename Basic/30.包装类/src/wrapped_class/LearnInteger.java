package wrapped_class;

/**
 * Integer 包装类
 * byte - Byte
 * boolean - Boolean
 * short - Short
 * char - Character
 * int - Integer
 * long - Long
 * float - Float
 * double - Double
 * 其它基本数据类型方法类似
 * @author Harln
 */
public class LearnInteger {

    public static void main(String[] args) {
        /* 基本数据类型转成包装类 */
        Integer integerNum1 = Integer.valueOf(9);
        Integer integerNum2 = Integer.valueOf(9);
        Integer integerNum = 9;

        /* 包装类转成基本类型 */
        int intNum = integerNum.intValue();
        //转成double类型
        double doubleNum = integerNum.doubleValue();

        /* 把字符串对象转换成包装类对象 */
        Integer e = Integer.valueOf("999999");
        /* 转化成二进制 */
        Integer e1 = Integer.parseInt("10",2);

        /* 把包装类对象转成字符串 */
        String str = e.toString();

        /* 常见的常量 */
        Integer number = Integer.MAX_VALUE;
    }
}
