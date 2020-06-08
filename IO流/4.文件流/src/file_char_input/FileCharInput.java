package file_char_input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @Author: Harlan
 * @Date: 2020/6/7 22:35
 */
public class FileCharInput {

    public static void  main(String[] args) {
        File file = new File("./4.四个抽象类/src/input.txt");
        FileReader reader = null;
        try{
            reader = new FileReader(file);
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
