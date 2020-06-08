package docking;

import java.io.*;

/**
 * 对接流:
 * 1.文件读取到字节数组中 File to ByteArray
 * 2.字节数组写到文件  ByteArray to File
 *
 * 1) 文件到程序 FileInputStream  --->  程序到字节数组 ByteArrayOutPutStream
 * 2) 字节数组到程序 ByteArrayInput  --->  程序到文件 FileOutputStream
 * @Author: Harlan
 * @Date: 2020/6/8 13:01
 */
public class Docking {

    public static void main(String[] args) {
        byte[] data = fileToByteArray("C:\\Users\\13536\\Desktop\\REFRESH-陈晓龙.m4a");
        byteArrayToFile(data, "C:\\Users\\13536\\Desktop\\REFRESH-陈晓龙1.m4a");
    }


    public static byte[] fileToByteArray(String filePath){
        File file = new File(filePath);
        InputStream fIs = null;
        ByteArrayOutputStream bAos = null;
        try{
            fIs = new FileInputStream(file);
            bAos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = fIs.read(flush)) != -1){
                bAos.write(flush,0,len);
                bAos.flush();
            }
            return bAos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fIs != null){
                try{
                    fIs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void byteArrayToFile(byte[] dest, String filePath){
        File file = new File(filePath);
        InputStream is = null;
        OutputStream os = null;
        try{
            is = new ByteArrayInputStream(dest);
            os = new FileOutputStream(file);
            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
