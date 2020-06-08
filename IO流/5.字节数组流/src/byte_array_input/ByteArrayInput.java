package byte_array_input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 * @Author: Harlan
 * @Date: 2020/6/7 23:03
 */

public class ByteArrayInput {
    public static void main(String[] args) {
        byte[] src = "talk is cheap show me the code.".getBytes();
        InputStream bAis = null;
        try {
            bAis = new ByteArrayInputStream(src);
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = bAis.read(flush)) != -1){
                String str = new String(flush,0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bAis != null){
                try {
                    bAis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
