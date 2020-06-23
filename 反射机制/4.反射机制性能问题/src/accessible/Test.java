package accessible;

import user.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Harlan
 * @Date: 2020/6/23 19:12
 */
public class Test {

    private final static long TIMES = 2000000000L;

    public static void ordinary(){
        User u = new User();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            u.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用20亿次,耗时:"+ (endTime - startTime) / 1000 +" s");
    }

    /**
     * 需要安全检测
     * @throws NoSuchMethodException 异常
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static void reflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class<?> clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            method.invoke(u, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方法调用20亿次,耗时:"+ (endTime - startTime) / 1000 +" s");
    }

    /**
     * 跳过安全检测
     * @throws NoSuchMethodException 异常
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static void reflectionNoAccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class<?> clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getName", null);
        method.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            method.invoke(u, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方法跳过安全检测调用20亿次,耗时:"+ (endTime - startTime) / 1000 +" s");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ordinary();
        reflection();
        reflectionNoAccess();
    }
}
