package commons;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 学习CommonsIO
 * 自行学习API
 * @Author: Harlan
 * @Date: 2020/6/9 16:14
 */
public class Cio {

    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("./1.认识IO/src/头像.jpg"));
        //目录大小
        long lneDir = FileUtils.sizeOfDirectory(new File("./1.认识IO"));
        System.out.println(len + "----" +lneDir);

        Collection<File> files = FileUtils.listFiles(new File("./1.认识IO"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
