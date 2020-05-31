package variable;

public class Variable {

    int num;    //成员变量,从属于对象;自动初始化
    static int num2;    //静态变量,从属于类

    public static void main(String[] args) {
        int num;    //局部变量,从属于方法

        for (int i = 0; i < 10; i++) {
            System.out.println(i);  //i-局部变量,从属于语句块
        }
    }
}
