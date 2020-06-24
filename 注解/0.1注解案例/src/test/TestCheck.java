package test;

import calculator.Calculator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Harlan
 * @Date: 2020/6/24 20:51
 */
public class TestCheck {

    public static void main(String[] args) {
        //1.创建计算器对象
        Calculator c = new Calculator();

        //2.获取字节码对象
        Class clz = c.getClass();

        //3.获取所有方法
        Method[] methods = clz.getDeclaredMethods();

        //6.捕获异常 记录到文件
        //异常出现次数
        int number = 0;
        File file = new File("./0.1注解案例/src/test/bug.txt");
        BufferedWriter bw = null;

        //4.判断方法是否有@Cheack注解
        for (Method method : methods) {
            //5.有则执行
            if (method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    number ++;
                    try {
                        bw = new BufferedWriter(new FileWriter(file));
                        bw.write(method.getName() + " 方法出现异常");
                        bw.newLine();
                        bw.write("异常的名称: "+e.getCause().getClass().getSimpleName());
                        bw.newLine();
                        bw.write("异常的原因: " + e.getCause().getMessage());
                        bw.newLine();
                        bw.write("------------------------");
                        bw.newLine();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                        System.out.println("文件写入异常...");
                    }
                }
            }
        }
        try {
            bw.write("本次一共出现 "+ number +" 次异常.");
        } catch (IOException e) {
            System.out.println("文件写入异常...");
            e.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
