package download_img_with_thread;

/**
 * 多线程类
 * @Author: Harlan
 * @Date: 2020/6/10 15:13
 */
public class ThreadDown extends Thread{

    private final String width;
    private final String height;
    private final String filePath;

    public ThreadDown(int num, int width, int heigh, String filePath){
        this.width = Integer.toString(width);
        this.height = Integer.toString(heigh);
        this.filePath =filePath;
    }


    @Override
    public void run() {
        super.run();
        DownloadImg di = new DownloadImg(10,this.width,this.height,this.filePath);
        di.download();
    }

    public static void main(String[] args) {
        ThreadDown td = new ThreadDown(10,300,300,"./1.创建线程/src/download_img_with_thread/img/imgThread/ ");
        ThreadDown td2 = new ThreadDown(10,500,500,"./1.创建线程/src/download_img_with_thread/img/imgThread2/ ");
        td.start();
        td2.start();
        DownloadImg di = new DownloadImg(10,"700","700", "./1.创建线程/src/download_img_with_thread/img/imgMain/ ");
        di.download();
    }
}
