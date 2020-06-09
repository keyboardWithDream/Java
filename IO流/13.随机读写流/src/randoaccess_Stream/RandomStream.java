package randoaccess_Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流 RandomAccessFile
 * @Author: Harlan
 * @Date: 2020/6/9 15:43
 */
public class RandomStream {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rAf = new RandomAccessFile(new File("./13.随机读写流/src/test.txt"), "r");
        //随机读取(指定起始位置)
        rAf.seek(2);
        //读取
        byte[] flush = new byte[1024];
        int len = -1;
        while((len = rAf.read(flush)) != -1){
            //分段写出
            rAf.write(flush,0,len);
        }
        rAf.close();
        System.out.println(new String(flush.toString()));
    }
}
