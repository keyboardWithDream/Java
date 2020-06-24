package exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

/**
 * 框架类:
 * 前提: 不改变该类任何代码
 * 可以创建任意类的对象, 且执行任意方法
 *
 * 实现: 1.配置文件  2.反射
 *
 * 步骤:
 * 1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 2.在程序中加载读取配置文件
 * 3.使用反射技术来加载类文件进内存
 * 4.创建对象
 * 5.执行方法
 *
 * @Author: Harlan
 * @Date: 2020/6/24 11:06
 */
public class Reflect {

    public static void main(String[] args) {
        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();

        //1.2获取class目录下的配置文件
        ClassLoader classLoader = Reflect.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.获取配置文件定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        try {
            Class<?> clazz = Class.forName(className);

            //4.创建对象
            Object obj = clazz.newInstance();

            //5.获取方法对象
            Method method = clazz.getMethod(methodName);
            method.invoke(obj);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
