package polymorphism;

/**
 * 多态 : 继承 + 方法重写 + 父类引用指向子类对象
 * @author Harlan
 */
public class Pylym {

    /**
     * 父类引用
     * @param animal 父类引用
     */
    static void animalShout(Animal animal){
        animal.shout();
    }

    public static void main(String[] args) {
        //子类对象
        Dog dog = new Dog();
        animalShout(dog);
    }
}

class Animal{
    public void shout(){
        System.out.println("叫了一声");
    }
}

class Dog extends Animal{
    /**
     *重写父类方法
     */
    @Override
    public void shout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    /**
     * 重写父类方法
     */
    @Override
    public void shout(){
        System.out.println("喵喵喵");
    }
}