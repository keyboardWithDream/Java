package 非静态内部类;

import org.w3c.dom.ls.LSOutput;

/**
 * 成员内部类的非静态内部类
 * @author Harlan
 */
public class InnerClass {
    public static void main(String[] args) {

        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.showOuterAge();
        inner.showInnerAge();
    }
}


class Outer {
    private int age = 10;
    public void testOuter(){
        System.out.println("Outer: 外部类");
    }

    /**
     * 内部类可以访问外部类的变量和方法
     * 不能有静态方法,属性,和初始化块
     * 外部类的静态方法,代码块,不能访问非静态内部类
     */
    class Inner{
        int age = 20;

        public void showInnerAge(){
            System.out.println("内部类的成员变量age:" + this.age);
        }

        public void showOuterAge(){
            System.out.println("外部类的成员变量age:" + Outer.this.age);
        }
    }
}