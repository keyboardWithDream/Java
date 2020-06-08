package character_set;

import java.io.*;
import java.net.URL;

/**
 * 转换流 InputStreamReader   OutputStreamWriter
 *  * 1.以字符流的形式操作字节流(纯文本)
 *  * 2.指定字符集
 * @Author: Harlan
 * @Date: 2020/6/8 21:29
 */
public class Convert {
    /**
     * 操作网络流 (下载百度源码)
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("./9.转换流/src/character_set/baidu.txt");
        byte[] data = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(),"utf-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"))) {
            String str;
            while ((str = reader.readLine()) != null){
                writer.write(str);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
