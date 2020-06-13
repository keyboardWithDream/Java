package cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟影院购座
 * @Author: Harlan
 * @Date: 2020/6/13 13:02
 */
public class CinemaOfSit {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Cinema cinema = new Cinema("Cinema", list);
        new Thread(new Customer(cinema,new ArrayList<>(1)),"C1").start();
        new Thread(new Customer(cinema,new ArrayList<>(3)),"C2").start();
        new Thread(new Customer(cinema,new ArrayList<>(5)),"C3").start();
        new Thread(new Customer(cinema,new ArrayList<>(7)),"C4").start();
        new Thread(new Customer(cinema,new ArrayList<>(9)),"C5").start();
        new Thread(new Customer(cinema,new ArrayList<>(1)),"C6").start();

    }
}

/**
 * 影院类
 */
class Cinema{
    private final List<Integer> sit;

    public Cinema(String name, List<Integer> sit) {
        this.sit = sit;
    }

    public boolean buySit(List<Integer> sitC){
        System.out.println("当前剩余: "+ sit+ "张");
        if (sit.containsAll(sitC)){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sit.removeAll(sitC);
            return true;
        }else {
            return false;
        }
    }
}

/**
 * 顾客类
 */
class Customer implements Runnable{

    final Cinema cinema;
    List<Integer> sitNum;

    public Customer(Cinema cinema, List<Integer> sitNum) {
        this.cinema = cinema;
        this.sitNum = sitNum;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag = cinema.buySit(sitNum);
            if (flag){
                System.out.println(Thread.currentThread().getName()+ "购买" +sitNum.size() + "张,成功!");
            }else {
                System.out.println(Thread.currentThread().getName() + "购买" +sitNum.size() + "张,失败!");
            }
            System.out.println("=======================");
        }
    }
}