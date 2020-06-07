package decode;

import java.io.UnsupportedEncodingException;

/**
 * 解码: 字节 ---> 字符串
 * 乱码问题: 1.字节数不够    2.字符集不统一
 * @Author: Harlan
 * @Date: 2020/6/7 13:45
 */
public class Decoed {

    public static void main(String[] args) {
        byte[] utf8 = {-26, -128, -89, -27, -111, -67, -25, -108, -97, -27, -111, -67, -28, -67, -65, -27, -111, -67};
        String msgUtf = new String(utf8);
        System.out.println(msgUtf);


        byte[] gbk = {-48, -44, -61, -4, -55, -6, -61, -4, -54, -71, -61, -4};
        String msgGbk = null;
        try{
            msgGbk = new String(gbk,0,gbk.length,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(msgGbk);
    }
}
