package create_thread;

/**
 * 创建线程方式一:
 * 1.创建: 继承Thread + 重写run
 * 2.启动: 创建子类对象 + 调用start方法
 * @Author: Harlan
 * @Date: 2020/6/10 14:37
 */
public class CreatThread extends Thread{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        //线程体
        super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程执行...");
        }
    }


    /**
     * 主程序入口
     * 主线程
     */
    public static void main(String[] args) {

        //启动线程(创建子类对象, 调用start启动)
        CreatThread ct = new CreatThread();
        ct.start();

        //主方法
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程执行...");
        }
    }
}
