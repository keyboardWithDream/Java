package separator;

import java.io.File;

/**
 * 名称分隔符(separator):  \  /
 * @Author: Harlan
 * @Date: 2020/6/6 20:23
 */
public class Separator {

    public static void main(String[] args) {
        String path = "C:/Users/13536/Desktop/Java/IO流/1.认识IO/src/头像.jpg";
        System.out.println(File.separatorChar);

        //常量拼接
        path = "C:"+File.separator+"User"+File.separator+"13536"+File.separator+"Desktop"+File.separator+"Java"+File.separator+"IO流"+File.separator+"1.认识IO"+File.separator+"src"+File.separator+"头像.jpg";
        System.out.println(path);
    }
}
