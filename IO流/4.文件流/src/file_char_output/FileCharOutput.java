package file_char_output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输出流
 * @Author: Harlan
 * @Date: 2020/6/7 22:44
 */
public class FileCharOutput {

    public static void main(String[] args) {
        File file = new File("./4.四个抽象类/src/output.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            String str = "你好! 世界!\r\n你好! 加瓦!\r\n你好! 号南\r\n";
            // 字符串 ---> 字符数组
            char[] data = str.toCharArray();
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                try{
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
