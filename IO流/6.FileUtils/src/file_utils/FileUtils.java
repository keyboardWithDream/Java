package file_utils;

import java.io.*;

/**
 * 1.封装拷贝
 * 2.封装释放资源
 *
 * @Author: Harlan
 * @Date: 2020/6/8 13:50
 */
public class FileUtils {

    public static void main(String[] args) {
        byte[] data = null;

        try {
            InputStream is = new FileInputStream("C:/Users/13536/Desktop/REFRESH-陈晓龙.m4a");
            ByteArrayOutputStream bAos = new ByteArrayOutputStream();
            data = fileToByteArray(is,bAos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream  is = new ByteArrayInputStream(data);
            OutputStream os = new FileOutputStream("C:/Users/13536/Desktop/REFRESH-陈晓龙1.m4a");
            byteArrayToFile(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对接输入输出流
     * @param is 文件输入流
     * @param bAos 数组输出流
     * @return 字节数组
     */
    public static byte[] fileToByteArray(InputStream is, ByteArrayOutputStream bAos){
        //try(流;流)自动释放资源
        try(is;bAos){
            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                bAos.write(flush,0,len);
                bAos.flush();
            }
            return bAos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对接
     * @param bAis 字节输入流
     * @param os 文件输出流
     */
    public static void byteArrayToFile(InputStream bAis, OutputStream os){
        //try(流;流)自动释放资源
        try(bAis; os){
            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = bAis.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
