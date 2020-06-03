package file_class;

import java.io.File;

/**
 * 递归打印目录树结构
 * @Author: Harlan
 * @Date: 2020/6/2 22:03
 */
public class RecursiveFile {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\13536\\Desktop\\2020春\\数据挖掘");
        printFiles(f,0);
    }

    static void printFiles(File file,int level){
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] f = file.listFiles();
            for (File files : f) {
                printFiles(files, level+1);
            }
        }
    }
}
