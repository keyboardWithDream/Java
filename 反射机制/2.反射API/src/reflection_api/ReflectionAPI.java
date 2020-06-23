package reflection_api;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API, 获取类的信息(类的名字, 属性, 方法, 构造器等)
 * @Author: Harlan
 * @Date: 2020/6/23 18:12
 */
public class ReflectionAPI {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        String path = "user.User";
        Class<?> userClazz = null;

        try{
            userClazz = Class.forName(path);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (userClazz != null){

            //获取包名+类名
            System.out.println(userClazz.getName());
            //获得类名
            System.out.println(userClazz.getSimpleName());

            System.out.println("========================");

            //获得属性信息(只能获取 public属性)
            Field[] fields = userClazz.getFields();
            //获得所有属性
            Field[] allFields = userClazz.getDeclaredFields();
            for (Field field : allFields) {
                System.out.println(field);
            }
            //获得对应属性
            Field field = userClazz.getDeclaredField("name");
            System.out.println(field);

            System.out.println("========================");

            //获得方法信息(同上) 控制声明 + 返回类型 + 方法名(参数类型)
            Method[] allMethods = userClazz.getDeclaredMethods();
            for (Method method : allMethods) {
                System.out.println(method);
            }
            System.out.println("--------------------------");
            //获取指定方法
            Method method1 = userClazz.getMethod("getName",null);
            System.out.println(method1);
            //必须传递参数类型对应的Class 对象
            Method method2 = userClazz.getDeclaredMethod("setId",int.class);
            System.out.println(method2);

            //获得构造器信息(同上)
            Constructor<?> constructor = userClazz.getConstructor();
            System.out.println("-----------------------------");
            Constructor<?>[] constructors = userClazz.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }
        }
    }
}
