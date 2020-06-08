package convert;

import java.io.*;

/**
 * 转换流 InputStreamReader   OutputStreamWriter
 * 1.以字符流的形式操作字节流(纯文本)
 * 2.指定字符集
 * @Author: Harlan
 * @Date: 2020/6/8 21:14
 */
public class Convert {
    public static void main(String[] args) {
        //操作System.in   和  System.out
       try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
           //循环获取键盘的输入(exit退出),输出次内容
           String msg = "";
           while (!"exit".equals(msg)){
               msg = reader.readLine();
               writer.write(msg);
               writer.newLine();
               //强制刷新
               writer.flush();
           }
       } catch (IOException e) {
           System.out.println("操作异常!");
       }

    }
}
