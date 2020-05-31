package 静态内部类;

/**
 * 静态内部类
 * @author Halran
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        //创建静态内部类对象
        Outter.Inner inner =  new Outter.Inner();
    }
}


class Outter{

    /**
     * 静态内部类
     */
    static class Inner{

    }
}