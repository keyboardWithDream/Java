package byte_input2;

import java.io.*;

/**
 * 这是一个测试类
 * @Author: Harlan
 * @Date: 2020/6/6 19:18
 */
public class Test {
    public static void main(String[] args) {
        musicToByte("C:/Users/13536/Desktop/REFRESH-陈晓龙.m4a","C:/Users/13536/Desktop/text.txt");
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
        File file = new File("./4.四个抽象类/test.txt");
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
