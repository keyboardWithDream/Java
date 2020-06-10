package download_img_with_thread;

/**
 * 多线程类
 * @Author: Harlan
 * @Date: 2020/6/10 15:13
 */
public class ThreadDown extends Thread{

    private String filePath;


    @Override
    public void run() {
        super.run();
        DownloadImg di = new DownloadImg("200","300",filePath);
        di.download();
    }

    public static void main(String[] args) {
        ThreadDown td = new ThreadDown();
        ThreadDown td2 = new ThreadDown();
        ThreadDown td3 = new ThreadDown();
        td.filePath = "./1.创建线程/src/imgThread/ ";
        td2.filePath = "./1.创建线程/src/imgThread2/ ";
        td3.filePath = "./1.创建线程/src/imgThread3/ ";
        td.start();
        td2.start();
        td3.start();
        DownloadImg di = new DownloadImg("600","700", "./1.创建线程/src/imgMain/ ");
        di.download();
    }
}
