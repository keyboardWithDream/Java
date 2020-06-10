package create_runnable;

/**
 * 创建线程第二种方法:
 * 1.创建: 实现Runnable + 重写run
 * 2.启动: 创建实现类对象 + Thread对象 + start
 * @Author: Harlan
 * @Date: 2020/6/10 16:52
 */
public class CreateThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程执行...");
        }
    }

    public static void main(String[] args) {
//        //创建实现类对象
//        CreatThread ct = new CreatThread();
//        //创建代理类对象
//        Thread t = new Thread(ct);
//        //启动
//        t.start();
        new Thread(new CreateThread()).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行...");
        }
    }
}
