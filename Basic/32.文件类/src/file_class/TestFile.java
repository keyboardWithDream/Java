package file_class;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File(文件类)
 * @Author: Harlan
 * @Date: 2020/6/2 19:42
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File f = new File("./32.文件类/src/file/text.txt");
        /* 打印地址 */
        System.out.println(f);

        /* 当前项目所在目录 */
        System.out.println(System.getProperty("user.dir"));

        File f2 = new File("./32.文件类/src/file/new.txt");
        f2.createNewFile();

        /* 其它常用方法 */
        System.out.println("File是否存在: "+f.exists());
        System.out.println("File是否是目录: "+f.isDirectory());
        System.out.println("File是否是文件: "+f.isFile());
        System.out.println("File最后修改时间: "+ new Date(f.lastModified()));
        System.out.println("File的大小: "+ f.length());
        System.out.println("File的文件名: "+f.getName());
        System.out.println("File的目录路径: "+f.getPath());
    }
}
