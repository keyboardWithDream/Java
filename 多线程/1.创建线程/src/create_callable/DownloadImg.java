package create_callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用多线程下载图片
 * 下载类
 * @Author: Harlan
 * @Date: 2020/6/10 15:01
 */
public class DownloadImg {

    private String url = "http://placekitten.com/width/high";
    private String file;
    private final int num;

    public DownloadImg(int num, String width, String height, String file) {
        this.num = num;
        this.file = file;
        this.url = this.url.replace("width", width).replace("high",height);
    }

    /**
     * 下载工具
     */
    public void download(){
        String[] fileArray = fileArray = this.file.split("/");
        String w = this.url.split("/")[3];
        String h = this.url.split("/")[4];
        for (int i = 0; i <= num; i++) {
            System.out.println(Thread.currentThread().getName() + " 已执行: "+ (float)i / (float) num * 100  +"%");
            String width = this.url.split("/")[3];
            String height = this.url.split("/")[4];
            fileArray = this.file.split("/");
            this.url = this.url.replace(width,String.valueOf(((Integer.parseInt(w))+i))).replace(height,String.valueOf(((Integer.parseInt(h))+i)));
            this.file = this.file.replace(fileArray[fileArray.length-1],width+"x"+ height+".jpg");
           try {
               FileUtils.copyURLToFile(new URL(this.url),new File(file));
           } catch (MalformedURLException e) {
               e.printStackTrace();
               System.out.println("下载链接错误!");
           } catch (IOException e) {
               e.printStackTrace();
               System.out.println("下载过程错误!");
           }
        }
    }
}
