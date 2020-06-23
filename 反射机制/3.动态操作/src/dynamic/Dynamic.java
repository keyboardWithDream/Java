package dynamic;

import user.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作: 构造器, 方法, 属性
 * @Author: Harlan
 * @Date: 2020/6/23 18:36
 */
public class Dynamic {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<User> clazz = (Class<User>) Class.forName("user.User");

        //通过动态调用构造方法, 构造对象
        //调用了Uer的无参构造方法
        User user1 = clazz.newInstance();

        //找到对应参数的构造方法,传参实例化对象
        Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
        User user2 = c.newInstance(1, 23, "Harlan");
        System.out.println(user2.toString());

        //通过反射API 调用普通方法
        User user3 = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.invoke(user3,"Harlan");
        System.out.println(user3.getName());

        //通过反射API 操作属性(私有属性不能直接操作) -- setAccessible(true)
        Field field = clazz.getDeclaredField("name");
        //设置属性不需要通过安全检查
        field.setAccessible(true);
        field.set(user3, "胡号南");
        System.out.println(user3.getName());
    }
}
