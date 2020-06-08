package byte_array_output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输出流
 * 1.创建源:内部维护
 * 2.选择流: 不关联源
 * 3.操作
 * 4.释放资源: 可以不用
 *
 * !!!获取数据 toByteArray()
 *
 * @Author: Harlan
 * @Date: 2020/6/7 23:29
 */
public class ByteArrayOutput {

    public static void main(String[] args) {
        byte[] dest = null;
        ByteArrayOutputStream bAos = null;
        try{
            bAos = new ByteArrayOutputStream();
            String str = "Show me the code";
            byte[] data = str.getBytes();
            bAos.write(data,0,data.length);
            bAos.flush();
            //获取数据
            dest = bAos.toByteArray();
            System.out.println(new String(dest,0,bAos.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bAos != null){
                try{
                    bAos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
