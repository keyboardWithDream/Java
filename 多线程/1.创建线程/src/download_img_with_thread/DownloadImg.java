package download_img_with_thread;

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
public class DownloadImg{

    private String url = "http://placekitten.com/width/high";
    private String file;
    private String width;
    private String height;



    public DownloadImg(String width, String height, String file) {
        this.width = width;
        this.height = height;
        this.file = file;
        this.url = this.url.replace("width", this.width).replace("high",height);
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    /**
     * 下载工具
     */
    public void download(){

        String[] fileArray = fileArray = this.file.split("/");
        String w = this.url.split("/")[3];
        String h = this.url.split("/")[4];
        for (int i = 0; i < 10; i++) {
            String width = this.url.split("/")[3];
            String height = this.url.split("/")[4];
            fileArray = this.file.split("/");
            System.out.println(width);
            this.url = this.url.replace(width,String.valueOf(((Integer.parseInt(w))+i))).replace(height,String.valueOf(((Integer.parseInt(h))+i)));
            this.file = this.file.replace(fileArray[fileArray.length-1],"img"+i+".jpg");
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
