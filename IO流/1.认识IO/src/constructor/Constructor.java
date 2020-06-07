package constructor;

import java.io.File;

/**
 * File 构造器
 * 相对路径 和 绝对路径
 * @Author: Harlan
 * @Date: 2020/6/6 20:39
 */
public class Constructor {
    public static void main(String[] args) {
        String path = "C:/Users/13536/Desktop/Java/IO流/1.认识IO/src/头像.jpg";

        //1.构建File对象
        File src = new File(path);
        System.out.println(src.length());

        //2.构建File对象(父子构建)
        src = new File("C:/Users/13536/Desktop/Java/IO流/1.认识IO/src", "头像.jpg");
        System.out.println(src.length());

        //3.构建File对象(父对象,子名称)
        src = new File(new File("C:/Users/13536/Desktop/Java/IO流/1.认识IO"), "头像.jpg");

        //绝对路径 getAbsolutePath() 获取绝对路径
        File f = new File(path);
        System.out.println(f.getAbsolutePath());

        //相对路径 user.dir (当前工程)
        System.out.println("当前工程:" +System.getProperty("user.dir"));
        f = new File("1.认识IO/src/头像.jpg");
        System.out.println(f.getAbsolutePath());

        //构建一个不存在的文件
        src = new File("1.认识IO/src/img");
        System.out.println(src.getAbsolutePath());
    }
}
