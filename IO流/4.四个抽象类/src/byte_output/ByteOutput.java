package byte_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流:
 * 1.创建源
 * 2.选择流
 * 3.操作(写出内容)
 * 3.释放资源
 * @Author: Harlan
 * @Date: 2020/6/7 17:08
 */
public class ByteOutput {

    public static void main(String[] args) {
        //1.创建源
        File src = new File("./4.四个抽象类/src/output.txt");
        //2.选择流
        FileOutputStream os = null;
        try{
            // append在文件末尾追加
            os = new FileOutputStream(src, true);
            String str = "IO is so EASY\r\n";
            //字符串 ---> 字节数组 (编码)
            byte[] data = str.getBytes();
            //3.操作(写出)
            os.write(data,0,data.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭
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
