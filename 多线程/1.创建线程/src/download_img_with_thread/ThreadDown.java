package download_img_with_thread;

/**
 * 多线程类
 * @Author: Harlan
 * @Date: 2020/6/10 15:13
 */
public class ThreadDown extends Thread{

    private String width;
    private String height;
    private String filePath;

    public ThreadDown(int width, int heigh, String filePath){
        this.width = Integer.toString(width);
        this.height = Integer.toString(heigh);
        this.filePath =filePath;
    }


    @Override
    public void run() {
        super.run();
        DownloadImg di = new DownloadImg(this.width,this.height,this.filePath);
        di.download();
    }

    public static void main(String[] args) {
        ThreadDown td = new ThreadDown(300,300,"./1.创建线程/src/imgThread/ ");
        ThreadDown td2 = new ThreadDown(500,500,"./1.创建线程/src/imgThread2/ ");
        td.start();
        td2.start();
        DownloadImg di = new DownloadImg("700","700", "./1.创建线程/src/imgMain/ ");
        di.download();
    }
}
