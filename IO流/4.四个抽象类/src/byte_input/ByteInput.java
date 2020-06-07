package byte_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字符流
 * @Author: Harlan
 * @Date: 2020/6/7 16:22
 */
public class ByteInput {

    public static void main(String[] args) {
        //1.创建源
        File file = new File("./4.四个抽象类/src/input.txt");
        //2.选择流
        FileInputStream is = null;
        try{
            //3.操作(按字节读取)
            is = new FileInputStream(file);
            //缓冲容器(1024b * 10大小读取) 1kb
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
