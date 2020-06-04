package 局部内部类;

/**
 *局部内部类
 * 作用域仅在方法内部
 * @author 13536
 */
public class LocalInnerClass {

    /**
     * 方法
     */
    public void show(){
        /**
         * 局部内部类定义
         */
        class Inner{
            public void fun(){
                System.out.println("局部内部类方法执行...");
            }
        }
        new Inner().fun();
    }


    public static void main(String[] args) {
        new LocalInnerClass().show();
    }
}
