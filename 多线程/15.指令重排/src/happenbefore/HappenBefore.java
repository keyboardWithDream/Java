package happenbefore;

/**
 * 指令重排: 代码执行顺序与预期不一致
 * 目的: 提高性能
 * @Author: Harlan
 * @Date: 2020/6/13 21:38
 */
public class HappenBefore {

    /**
     * 变量 a
     * 变量 flag
     */
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            a = 0;
            flag = true;

            //线程1更改数据
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            //线程2读取数据
            Thread t2 = new Thread(()->{
                if (flag){
                    a *= 1;
                }
                //指令重排
                if (a == 0){
                    System.out.println("Happen before ->" + a);
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    private static void test() throws InterruptedException {

    }
}
