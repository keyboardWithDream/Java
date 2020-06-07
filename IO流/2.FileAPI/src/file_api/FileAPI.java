package file_api;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * File类 API 学习:
 *
 * 名称或路径: getName()  getPath()  getAbsolutePath()  getParent()
 * 文件状态: exists()判断存在   isFile()判断文件    isDirectory()判断文件夹
 * 创建文件(存在不能创建): createNewFile()       删除文件:delete()
 *
 * @Author: Harlan
 * @Date: 2020/6/7 10:50
 */
public class FileAPI {

    public static void main(String[] args) {
        System.out.println("当前路径: "+ System.getProperty("user.dir"));
        File src = new File("2.FileAPI/src/img/头像.jpg");

        System.out.println("文件大小: "+src.length()+"b");
        System.out.println("文件名称: "+src.getName());
        System.out.println("文件路径: "+src.getPath());
        System.out.println("绝对路径: "+src.getAbsolutePath());
        System.out.println("父路径: "+src.getParent());
        System.out.println("父对象: "+ src.getParentFile().getName());

        System.out.println("=========================");

        System.out.println("路径是否存在: "+src.exists());
        System.out.println("是否为文件: "+src.isFile());
        System.out.println("是否为文件夹: "+src.isDirectory());

        System.out.println("==========================");

        //创建和删除
        File file = new File("2.FileAPI/src/text.txt");
        boolean flag = false;
        try {
            flag = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件是否创建成功: "+flag);

        System.out.println("==========================");

        //判断文件状态
        System.out.println("请输入文件路径: ");
        Scanner scanner = new Scanner(System.in);
        String pathStr = scanner.nextLine();
        File f = new File(pathStr);
        if (f == null || !f.exists()){
            System.out.println("文件路径不存在!");
        }else {
            if (f.isFile()){
                System.out.println("这是一个文件,大小为:"+f.length()+"b");
            }else {
                System.out.println("这是一个文件夹!");
            }
        }
    }
}
