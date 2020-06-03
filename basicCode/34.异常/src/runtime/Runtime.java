package runtime;

/**
 * RuntimeException 运行异常(通常是程序编译错误)
 * @Author: Harlan
 * @Date: 2020/6/3 13:45
 */
public class Runtime {

    public static void main(String[] args) {

        int b = 0;
        try {
            System.out.println(1/b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}
