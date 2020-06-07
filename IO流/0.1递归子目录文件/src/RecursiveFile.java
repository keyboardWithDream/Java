import java.io.File;

/**
 * 递归目录和文件
 * 统计文件夹大小
 * @Author: Harlan
 * @Date: 2020/6/7 12:16
 */
public class RecursiveFile {

    public static void main(String[] args) {
        File src = new File("./");
        System.out.println(src.getAbsolutePath());
        printFile(src, 0);
        howBigFile(src);
        System.out.println(big);
    }

    public static void printFile(File src, int deep){
        System.out.println(deep +":"+src.getName());
        if (src==null || !src.exists()){
            return;
        }else if (src.isDirectory()){
            for (File s: src.listFiles()) {
                printFile(s, deep+1);
            }
        }
    }

    //统计大小
    private static long big = 0;
    public static void howBigFile(File src){
        if (src!=null && !src.exists()){
            if (src.isFile()){
                big += src.length();
            }else {
                for (File f: src.listFiles()) {
                    howBigFile(f);
                }
            }
        }
    }
}
