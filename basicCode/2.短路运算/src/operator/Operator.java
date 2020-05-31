package operator;

public class Operator {

    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;

        System.out.println(b1 & b2 );
        System.out.println(b1 | b2 );
        System.out.println(b1 ^ b2 );
        System.out.println(!b1);

        //短路运算
        //算路与,第一个值为false则不需计算后面的操作数
        boolean b3 = 1 > 2 && 2 < (3 / 0);
        System.out.println(b3);
    }
}
