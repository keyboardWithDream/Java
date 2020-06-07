package encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 编码: 字符串 ---> 字节
 *
 * @Author: Harlan
 * @Date: 2020/6/7 13:35
 */
public class Encode {

    public static void main(String[] args) {
        String msg = "性命生命使命";

        //编码
        byte[] data = msg.getBytes();
        System.out.println(Arrays.toString(data));
        System.out.println("utf-8 长度: "+data.length);
        System.out.println("==================");

        //编码:其它字符集
        try{
            data = msg.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(data));
        System.out.println("GBK 长度: "+data.length);
    }
}
