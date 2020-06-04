package checked;

import java.io.FileReader;
import java.io.IOException;

/**
 * CheckedException(编译无法通过)
 * 解决方法: try{}  catch(){}(一或多个)  finally{}
 * 子类异常在父类异常之前
 * 2.throws 抛出
 * IO流演示
 * @Author: Harlan
 * @Date: 2020/6/3 14:26
 */
public class Checked {
    public static void main(String[] args) throws IOException {
        readFile();
        readFiles();
    }

    /**
     * try{} catch(){} finally{}
     */
    public static void readFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("./34.异常/src/test.txt");
            int c = reader.read();
            System.out.println((char) c);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 调用者抛出 throws
     * @throws IOException
     */
    public static void readFiles() throws IOException {
        FileReader reader = new FileReader("./34.异常/src/test.txt");
        int c = reader.read();
        System.out.println((char)c);
        if (reader != null){
            reader.close();
        }
    }
}
