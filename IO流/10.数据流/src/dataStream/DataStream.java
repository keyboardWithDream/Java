package dataStream;

import java.io.*;


/**
 * 数据流(保存了数据类型):
 * 1.先写出,后读取
 * 2.读取的顺序与写出保持一致
 * DataInputStream
 * DataOutputSteam
 * @Author: Harlan
 * @Date: 2020/6/9 14:21
 */
public class DataStream {
    public static void main(String[] args) throws IOException {
        /**
         * 写出
         */
        ByteArrayOutputStream bAos = new ByteArrayOutputStream();
        DataOutputStream dOs = new DataOutputStream(bAos);
        byte[] data = bAos.toByteArray();
        //操作数据类型 + 数据
        dOs.writeUTF("编码心酸泪,谁解其中味");
        dOs.writeInt(18);
        dOs.writeBoolean(true);
        dOs.writeChar('A');
        bAos.flush();
        data = bAos.toByteArray();

        /**
         * 读取
         */
        DataInputStream dIs = new DataInputStream(new ByteArrayInputStream(data));
        //顺序与写出一致
        String str = dIs.readUTF();
        int age = dIs.readInt();
        boolean flag = dIs.readBoolean();
        char c = dIs.readChar();
        System.out.println(str+age+flag+c);
    }
}
