package buffer;

import java.io.*;

/**
 * 分段读取字节输入流 加入缓存流
 * 关闭时 由里到外
 * @Author: Harlan
 * @Date: 2020/6/8 19:05
 */
public class BufferFile {

    public static void main(String[] args) {
        input();
        output();
    }

    public static void input(){
        File file = new File("C:\\Users\\13536\\Desktop\\REFRESH-陈晓龙.m4a");
        //加入缓冲流
        try(InputStream is = new BufferedInputStream(new FileInputStream(file))){
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void output(){
        File file = new File("./8.缓冲流/src/buffer/text.txt");
        byte[] data = "Hello World!!!!!!!!!!!!!!\r\n".getBytes();
        //加入缓冲流
        try(OutputStream os = new BufferedOutputStream(new FileOutputStream(file,true))){
            os.write(data,0,data.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

