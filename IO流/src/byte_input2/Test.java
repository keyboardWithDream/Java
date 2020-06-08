package byte_input2;

import java.io.*;
import java.util.Arrays;

/**
 * 这是一个测试类
 * @Author: Harlan
 * @Date: 2020/6/6 19:18
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(input()));
        output(input());
    }


    public static byte[] input(){
        File file = new File("C:/Users/13536/Desktop/REFRESH-陈晓龙.m4a");
        InputStream fIs = null;
        ByteArrayOutputStream bAos = null;
        byte[] dest = null;
        try{
            fIs = new FileInputStream(file);
            bAos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = fIs.read(flush)) != -1){
                bAos.write(flush,0,flush.length);
                bAos.flush();
                dest = bAos.toByteArray();
            }
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
        return dest;
    }

    public static void output(byte[] dest){
        File file = new File("C:/Users/13536/Desktop/REFRESH-陈晓龙1.m4a");
        ByteArrayOutputStream bAos = null;
        OutputStream os = null;
        try{
            bAos = new ByteArrayOutputStream();
            os = new FileOutputStream(file);
            bAos.write(dest,0,dest.length);
            bAos.flush();
            byte[] data = bAos.toByteArray();
            os.write(data, 0, data.length);
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



    public static void musicToByte(String musicFile, String byteFile){
        File musicF = new File(musicFile);
        File byteF = new File(byteFile);

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(musicF);
            os = new FileOutputStream(byteF);
            byte[] flush = new byte[1025 * 10];
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
                try{
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try{
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }





    public static void printFile(){
        File file = new File("");
        InputStream is = null;
        try{
            int temp;
            is = new FileInputStream(file);
            while ((temp = is.read()) != -1){
                if ((char)temp == '\n'){
                    System.out.println();
                }else {
                    System.out.print((char) temp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null){
                try{
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
