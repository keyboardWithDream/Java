package create_callable;


import java.util.concurrent.*;

/**
 * 创建线程的第三种方式(可有返回值, 可以抛出异常)
 * 1.创建目标对象
 * 2.创建执行服务
 * 3.提交执行结果
 * 4.获取结果
 * 5.关闭服务
 *
 * @Author: Harlan
 * @Date: 2020/6/11 11:37
 */
public class CreatCallable implements Callable<Boolean> {

    private final String width;
    private final String height;
    private final String filePath;

    public CreatCallable(int num, int width, int heigh, String filePath){
        this.width = Integer.toString(width);
        this.height = Integer.toString(heigh);
        this.filePath =filePath;
    }

    @Override
    public Boolean call() throws Exception {
        DownloadImg dl = new DownloadImg(10,this.width,this.height,this.filePath);
        dl.download();
        return true;
    }

    public static void main(String[] args) {
        CreatCallable c1 = new CreatCallable(10,300,300,"./1.创建线程/src/create_callable/img/imgCallable1/ ");
        CreatCallable c2 = new CreatCallable(10,500,500,"./1.创建线程/src/create_callable/img/imgCallable2/ ");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = service.submit(c1);
        Future<Boolean> result2 = service.submit(c2);
        //获取结果
        try {
            boolean r1 = result1.get();
            boolean r2 = result2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //关闭服务
        service.shutdown();
    }
}
