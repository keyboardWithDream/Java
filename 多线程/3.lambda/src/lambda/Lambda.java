package lambda;

/**
 * Lambda 表达式 简化线程(用一次)的使用
 * @Author: Harlan
 * @Date: 2020/6/11 14:28
 */
public class Lambda {

    /**
     * 静态内部类(用一次)
     * 如果不使用则不会进行编译
     */
    static class Test1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("线程1正在执行...");
            }
        }
    }

    public static void main(String[] args) {

        //启动线程Test1
        new Thread(new Test1()).start();

        /**
         * 局部内部类
         */
        class Test2 implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("线程2正在执行...");
                }
            }
        }
        //启动线程Test2
        new Thread(new Test2()).start();

        /**
         * 匿名内部类 必须借助接口或者父类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3正在执行...");
            }
        }).start();


        /**
         * lambda简化
         * ()->类型自动推导
         */
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("lambda简化线程正在执行...");
            }
        }).start();


        for (int i = 0; i < 20; i++) {
            System.out.println("主线程正在执行...");
        }
    }
}
