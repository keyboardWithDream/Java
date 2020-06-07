package dir;

import java.io.File;
import java.util.Arrays;

/**
 * 关于文件夹的API
 *
 * 创建目录:  mkdir()       mkdirs()
 * 列出下一级:  list() 列出下级名称(返回String数组)     listFile()列处下级File对象
 * 列出所有的盘符: listRoot()
 * @Author: Harlan
 * @Date: 2020/6/7 11:53
 */
public class Directory {

    public static void main(String[] args) {

        //创建文件夹
        File dir = new File("2.FileAPI/src/dir/textDir");
        boolean flag = dir.mkdir();
        System.out.println("文件夹是否创建成功: "+flag);
        dir = new File("2.FileAPI/src/dir/textDir/textDir2/textDir3");
        flag = dir.mkdirs();
        System.out.println("文件夹是否创建成功: "+flag);
        System.out.println("====================");

        //列出下级(一层)
        dir = new File("../IO流");
        String[] subNames = dir.list();
        for (String name : subNames) {
            System.out.println(name);
        }
        System.out.println("====================");

        //列出下级对象
        File[] files = dir.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("====================");

        //列出所有盘符
        File[] root = File.listRoots();
        System.out.println(Arrays.toString(root));
    }
}
