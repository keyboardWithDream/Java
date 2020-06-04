package abstract_method_class;

/**
 * 抽象方法,抽象类 作用:规范子类写法,子类必须实现相关抽象方法
 * 父类
 * @author Harlan
 */
abstract public class Father {
    /**
     * 有抽象方法的类 必须是抽象类
     * 抽象类也可以定义普通方法
     * 1.抽象类不能实例化
     * 2.必须子类继承实现
     */
    abstract public void hello();

    public void run(){
        System.out.println("正在跑...");
    }
}

/**
 * 子类必须重写抽象方法
 */
class Child extends Father{

    @Override
    public void hello() {
        System.out.println("Say Hello!");
    }

    public static void main(String[] args) {
        Father child = new Child();
        child.hello();
        child.run();
    }
}