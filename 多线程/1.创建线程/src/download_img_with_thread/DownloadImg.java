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
        String[] urlArray = null;
        String[] fileArray = null;
        for (int i = 0; i < 10; i++) {
            urlArray = this.url.split("/");
            fileArray = this.file.split("/");
            System.out.println(urlArray[3]);
            this.url = this.url.replace(urlArray[3],String.valueOf(((Integer.parseInt(urlArray[3]))+i))).replace(urlArray[4],String.valueOf(((Integer.parseInt(urlArray[4]))+i)));
            this.file = this.file.replace(fileArray[fileArray.length-1],"img"+urlArray[3]+".jpg");
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
