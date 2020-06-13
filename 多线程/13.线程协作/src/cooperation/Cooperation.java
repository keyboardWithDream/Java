package cooperation;

/**
 * 线程协作(生产者消费者模式)
 * 管程法
 *
 * @Author: Harlan
 * @Date: 2020/6/13 15:33
 */
public class Cooperation {

    public static void main(String[] args) {
        SysContainer sysContainer = new SysContainer();
        new Producer(sysContainer).start();
        new Consumer(sysContainer).start();
    }
}

/**
 * 生产者
 */
class Producer extends Thread{
    SysContainer container;

    public Producer(SysContainer container) {
        this.container = container;
    }

    /**
     * 开始生产
     */
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("厂家: " + i+"--->正在生产...");
            container.push(new Commodity(i));
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread{
    SysContainer container;

    public Consumer(SysContainer container) {
        this.container = container;
    }

    /**
     * 开始消费
     */
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("顾客: "+ container.pop().getId()+" 正在消费...");
        }
    }
}

/**
 * 缓冲区
 */
class SysContainer{
    /**
     * Commodity[] 容器
     * count 计数器
     */
    private Commodity[] commodities = new Commodity[10];
    private int count;

    /**
     * 存贮生产
     * @param commodity
     */
    public synchronized void push(Commodity commodity){
        if (count >= commodities.length){
            try {
                //生产阻塞
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.commodities[count] = commodity;
        //激活消费
        this.notifyAll();
        count++;
    }

    /**
     * 获取
     * @return
     */
    public synchronized Commodity pop(){
        if (count <= 0){
            try {
                //消费阻塞
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Commodity commodity = this.commodities[count];
        //激活生产
        this.notifyAll();
        return commodity;
    }
}

/**
 * 商品
 */
class Commodity {
    private int id;

    public Commodity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}