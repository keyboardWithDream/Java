package decorator;

import java.util.Date;

/**
 * 装饰器
 * 实现放大器对声音放大的功能(代码被注释)
 * 模拟咖啡
 * 4个角色组成:
 * 1.抽象组件:需要装饰的抽象对象(接口或抽象父类)
 * 2.具体的组件:需要装饰的对象
 * 3.抽象装饰类:包含了对抽象组件的引用以及装饰者共有的方法
 * 4.具体装饰类:被装饰的对象
 * @Author: Harlan
 * @Date: 2020/6/8 17:50
 */
public class Decorator {

    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger = new Suger(coffee);
        System.out.println(suger.info() +" "+suger.cost());
        System.out.println("=====================");
        Drink milk = new Milk(coffee);
        System.out.println(milk.info()+" "+milk.cost());
        System.out.println("=====================");
        milk = new Milk(suger);
        System.out.println(milk.info()+" "+milk.cost());
//        Person p = new Person();
//        p.say();
//
//        Amplifier amplifier = new Amplifier(p);
//        amplifier.say();
    }
}

/**
 * 抽象组件
 * cost 价格
 * info 信息
 */
interface Drink{
    double cost();
    String info();
}

/**
 * 具体组件
 */
class Coffee implements Drink{

    private String name = "原味";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

/**
 * 抽象装饰类
 */
abstract class Decorate implements Drink{

    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

/**
 * 具体的装饰类
 */
class Milk extends Decorate{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() * 4;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶.";
    }
}

/**
 * 具体装饰类2
 */
class Suger extends Decorate{

    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() * 2;
    }

    @Override
    public String info() {
        return super.info() + "加入了糖";
    }
}
//interface Say{
//    void say();
//}
//
//class Person implements Say{
//    /**
//     * 声音的分贝
//     */
//    private int voice = 10;
//
//    public int getVoice() {
//        return voice;
//    }
//
//    public void setVoice(int voice) {
//        this.voice = voice;
//    }
//
//    @Override
//    public void say() {
//        System.out.println("人的声音为: "+ this.getVoice() +"分贝.");
//    }
//}
//
///**
// * 放大器
// */
//class Amplifier implements Say{
//
//    private Person p;
//    Amplifier(Person p){
//        this.p = p;
//    }
//
//    @Override
//    public void say() {
//        System.out.println("人的声音为: " + p.getVoice()*100 + "分贝.");
//    }
//}