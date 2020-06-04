package access_character;

/**
 * 访问控制符
 * |修饰符      一个类里        同一个包        子类      所有类
 * |private     GET
 * |[default]   GET            GET
 * |protected   GET            GET           GET
 * |public      GET            GET           GET      GET
 * @author Harlan
 */
public class AccessCaracter {
    public static void main(String[] args) {
        Human human = new Human();

        //age 为私有变量 只有自己可访问
        human.setAge(23);
        human.getAge();

        //name 为default变量 同一个包可以访问
        human.name = "Harlan";
        System.out.println(human.name);

        //height 为protected变量 子类可以访问
        Man man = new Man();
        man.height = 100;
        man.getHeight();
    }
}

class Human{

    /**
     * private 不同类不可见
     */
    private int age;

    /**
     * default 默认修饰:同一个包可见
     */
    String name;

    /**
     * protected 子类可访问
     */
    protected int height;

    /**
     * public 修饰所有类可访问
     * 需要set get 方法访问 age
     * @param age 年龄
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void getAge(){
        System.out.println("Human年龄: " + age);
    }
}

class Man extends Human{
    public void getHeight(){
        System.out.println("身高为: " + super.height);
    }
}