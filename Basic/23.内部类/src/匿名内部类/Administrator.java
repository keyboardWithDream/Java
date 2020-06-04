package 匿名内部类;

/**
 * 匿名内部类
 * @author Harlan
 */
public class Administrator {
    /**
     * 方法定义
     * @param ainterface 形参
     */
    public static void test(Ainterface ainterface){
        System.out.println("test 方法执行...");
        ainterface.abc();
        ainterface.bcd();
    }


    public static void main(String[] args) {
        //匿名内部类
        test(new Ainterface() {

            @Override
            public void abc() {
                System.out.println("abc 方法执行...");
            }

            @Override
            public void bcd() {
                System.out.println("bcd 方法执行...");
            }

        });
    }
}

/**
 * 接口
 */
interface Ainterface{
    void abc();
    void bcd();
}