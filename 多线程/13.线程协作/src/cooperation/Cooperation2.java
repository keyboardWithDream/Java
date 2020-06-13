package cooperation;

/**
 * 生产者消费者模式实现2: 信号灯法
 * 借助标志位
 *
 * @Author: Harlan
 * @Date: 2020/6/13 18:42
 */
public class Cooperation2 {
    public static void main(String[] args) {
        Rsc rsc = new Rsc();
        Producer1 producer = new Producer1(rsc);
        Consumer1 consumer = new Consumer1(rsc);
        producer.start();
        consumer.start();
    }
}



/**
 * 同一个资源
 */
class Rsc{
    /**
     * product 产品
     * flag 信号灯
     * true 消费者等待
     * false 生产者等待
     */
    String product;
    boolean flag = true;

    /**
     * 生产
     */
    public synchronized void produce(String product){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者: 已生产 " + product);
        this.product = product;
        this.notifyAll();
        this.flag = !this.flag;
    }

    /**
     * 消费
     */
    public synchronized void buy(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者: 已买到: "+ product);
        this.notifyAll();
        this.flag = !this.flag;
    }
}

class Producer1 extends Thread{
    Rsc rsc;

    public Producer1(Rsc rsc){
        this.rsc = rsc;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 30; i++) {
            this.rsc.produce("商品"+i);
        }
    }
}

class Consumer1 extends Thread{
    Rsc rsc;

    public Consumer1(Rsc rsc) {
        this.rsc = rsc;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 30; i++) {
            this.rsc.buy();
        }
    }
}