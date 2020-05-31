package final_keyword;

/**
 * final 关键字
 * final 修饰变量 - 变量不可改变
 * final 修饰方法 - 方法不可被子类重写,但可重载
 * final 修饰 类  - 类不能被继承
 * @author 13536
 */
public class FinalWord {

    static void animalShout(Animal animal){
        animal.shout();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        animalShout(dog);
    }
}

class Animal{
    /**
     * shout方法不能被重写
     */
    final public void shout(){
        System.out.println("叫了一声");
    }
}

/**
 * Dog 类 不能被继承
 */
final class Dog extends Animal{
    /**
     * shout 方法不能被重写
     */
    public void dogShout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    /**
     * shout 方法不能被重写
     */
    public void catShout(){
        System.out.println("喵喵喵");
    }
}

// class SmallDog extends Dog{}   Dog类 被final修饰不能被继承

