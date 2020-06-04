package operator;

public class Operator {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~a);

        //移位 二进制基底
        int c = 3<<2;
        System.out.println(c);
        c = c >> 4;
        System.out.println(c);
    }
}
