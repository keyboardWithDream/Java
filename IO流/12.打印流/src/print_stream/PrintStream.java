package print_stream;

import java.io.*;

/**
 * 打印流 PrintStream
 * @Author: Harlan
 * @Date: 2020/6/9 15:22
 */
public class PrintStream {

    private static Object FileDescriptor;

    public static void main(String[] args) throws FileNotFoundException {
        //打印流 System.out
        java.io.PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        ps = new java.io.PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
        ps.println("这就是打印流!!!!!!!!!!");
        ps.println("完全没有听懂!!!!!!!!!!!!!");

        //重定向输出端
        System.setOut(ps);
        System.out.println("已经重新定向!");
        ps.flush();
        //重回控制台
        System.setOut(new java.io.PrintStream(new BufferedOutputStream(new FileOutputStream(java.io.FileDescriptor.out)),true));
        System.out.println("控制台!");
        ps.close();
    }
}
