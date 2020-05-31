package interfaceer;

/**
 * 接口:所有的方法都是抽象的,更全面的规范
 * interface 接口名 [extends 父接口1, 父接口2...] { 常量定义, 方法定义}
 * 通过子类实现
 * @author Harln
 */
public interface MyInterface {
    /**
     * public static final int MAX_AGE
     */
    int MAX_AGE = 120;

    /**
     * public abstract void sayHello();
     */
    void getMaxAge();
}


/**
 * implements 实现
 * 重写抽象类
 * 可直接调用接口定义的常量
 */
class MyClass implements MyInterface{

    @Override
    public void getMaxAge() {
        System.out.println(MAX_AGE);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.getMaxAge();
    }
}