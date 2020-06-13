package syn_safe;

/**
 * 线程安全: 同步块--目标更明确
 * @Author: Harlan
 * @Date: 2020/6/12 17:34
 */
public class SynSafe2 {

    public static void main(String[] args) {
        Account a1 = new Account(100,"账户1");
        Drawing d1 = new Drawing(a1,40,0,"王五");
        Drawing d2 = new Drawing(a1,50,0,"李四");
        Drawing d3 = new Drawing(a1,60,0,"张三");
        d1.start();
        d2.start();
        d3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a1.name+"--->账户余额为: "+a1.money);
    }
}

/**
 * 账户
 */
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


/**
 * 模拟取款
 */
class Drawing extends Thread{

    Account account;
    int drawingMoney;
    int packetTotal;

    public Drawing(Account account, int drawingMoney, int packetTotal, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.packetTotal = packetTotal;
    }

    /**
     * 锁定资源(同步块)
     */
    public synchronized void getMoney(){
        //提高性能代码
        if (account.money <= 0){
            return;
        }
        //锁定account
        synchronized (account){
            if (account.money - drawingMoney < 0){
                System.out.println(this.getName()+"--->"+"未取到钱,余额不足!");
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(account.name + "--->账户余额为: "+account.money);
            System.out.println(this.getName()+ "--->口袋的钱为: "+packetTotal);
        }
    }

    @Override
    public void run(){
        getMoney();
    }
}
