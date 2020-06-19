package reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射 : 把Java类中的各种结构(方法, 属性, 构造器, 类名)映射成一个Java对象
 * 1.获取Class 对象(3种方式获取) : 推荐使用Class.forName("包名.类名") -- 抛出异常
 * 2.可以动态创建对象
 * @Author: Harlan
 * @Date: 2020/6/19 16:08
 */
public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取Class对象
        //1. 对象.getClass
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();

        //2. 类.class
        clz = Iphone.class;

        //3. Class.forName("包名.类名")
        clz = Class.forName("reflect.Iphone");

        //动态创建对象
//        Iphone iphone1 = (Iphone)clz.newInstance();
//        System.out.println(iphone1);

        Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}

/**
 * Iphone类 解析
 */
class Iphone{
    /**
     * 无参构造
     */
    public Iphone(){

    }
}