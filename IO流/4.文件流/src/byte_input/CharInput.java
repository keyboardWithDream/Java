package byte_input;

import java.io.*;

/**
 * 标准步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 *
 * 测试文件字节流
 * @Author: Harlan
 * @Date: 2020/6/7 15:20
 */
public class CharInput {

    public static void main(String[] args) {
        //1.创建源
        File file = new File("./4.四个抽象类/src/input.txt");
        //2.选择流
        InputStream is = null;
        try {
             is = new FileInputStream(file);
            //3.操作
            int temp;
            while ((temp = is.read()) != -1){
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
