package constant;
import java.math.BigDecimal;    //精确的浮点运算
import java.math.BigInteger;    //精确的整型计算

public class Constant {

    public static void main(String[] args) {
        //不可更改的量为常量 定义时(大写字母和下划线)
        final double PI = 3.14; //final定义不能修改
        double r = 3;
        double area = 2 * PI * Math.pow(r, 2);
        System.out.println("面积为:"+area);

        System.out.println("==============");

        BigDecimal num = BigDecimal.valueOf(1.0);
        // num - 0.5
        num = num.subtract(BigDecimal.valueOf(0.1));
        num = num.subtract(BigDecimal.valueOf(0.1));
        num = num.subtract(BigDecimal.valueOf(0.1));
        num = num.subtract(BigDecimal.valueOf(0.1));
        num = num.subtract(BigDecimal.valueOf(0.1));
        System.out.println(num);    //精确
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);  //不精
        BigDecimal num1 = BigDecimal.valueOf(1.0);
        BigDecimal num2 = BigDecimal.valueOf(1.0 / 10.0);
        System.out.println(num1.equals(num2));  //equals()比较;返回false true
    }
}
