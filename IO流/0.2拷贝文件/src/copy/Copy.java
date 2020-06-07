package copy;

import java.io.*;

/**
 * 文件拷贝: 文件字节输入,输出流
 * 1.创建源
 * 2.选择流
 * 3.操作(写出内容)
 * 4.释放资源(先打开,后关闭)
 * @Author: Harlan
 * @Date: 2020/6/7 19:22
 */
public class Copy {

    public static void main(String[] args) {
        File oldFile = new File("C:\\Users\\13536\\Desktop\\Java\\IO流\\0.2拷贝文件\\src\\img\\old.jpg");
        File newFile = new File("C:\\Users\\13536\\Desktop\\Java\\IO流\\0.2拷贝文件\\src\\img\\new.jpg");

        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            is = new FileInputStream(oldFile);
            os = new FileOutputStream(newFile);
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                    if (is != null){
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
