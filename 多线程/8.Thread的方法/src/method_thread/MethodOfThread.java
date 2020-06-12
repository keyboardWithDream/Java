package method_thread;

/**
 * 其它方法
 * @Author: Harlan
 * @Date: 2020/6/12 14:02
 */
public class MethodOfThread {

    public static void main(String[] args) {
        //设置名称: 真实角色+代理角色
        ThreadTest threadTest = new ThreadTest("test");
        Thread t = new Thread(threadTest);
        //设置名字
        t.setName("t");
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //判断是否存活
        System.out.println(t.isAlive());
    }
}

class ThreadTest implements Runnable{

    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //判断是否存活
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().getName() + "--->"+name);
    }
}