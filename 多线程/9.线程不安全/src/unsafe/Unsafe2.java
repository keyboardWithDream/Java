package unsafe;

/**
 * 线程不安全:取钱
 * @Author: Harlan
 * @Date: 2020/6/12 14:41
 */
public class Unsafe2 {

    public static void main(String[] args) {
        Account a1 = new Account(20,"账户1");
        Drawing d1 = new Drawing(a1,20,0,"王五");
        Drawing d2 = new Drawing(a1,20,0,"李四");
        d1.start();
        d2.start();
        try {
            Thread.sleep(5000);
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

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (account.money - drawingMoney < 0){

        }else {
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
        }
        System.out.println(this.getName()+ "--->账户余额为: "+account.money);
        System.out.println(this.getName()+ "--->口袋的钱为: "+packetTotal);
    }
}