package definitionclass;

/**
 * 定义类:
 * 类包括属性和方法
 * @author harlan
 */
public class Student {

    /**
     * 构造方法:用于创建这个类的对象
     * 无参构造方法可以由系统自动创建
     */
    Student(){

    }

    //属性 fields
    int id;
    String name;
    int age;

    Computer computer;

    //方法
    void study(){
        System.out.println(name + ": 正在用" + computer.brand + "学习...");
    }
    void play(){
        System.out.println(name + ": 正在玩耍...");
    }


    //程序执行入口
    public static void main(String[] args) {
        //创建对象
        Student harlan = new Student();
        harlan.name = "harlan";
        harlan.play();

        Computer c = new Computer();
        c.brand = "Apple电脑";
        harlan.computer = c;
        harlan.study();
    }
}


/**
 * 一个源文件只能有一个public类
 * 第二个类
 */

class Computer{
    String brand;
}