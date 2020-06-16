package Spider;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫: 1.获取URL 2.下载资源 3.下载数据 4.分析资源
 * @Author: Harlan
 * @Date: 2020/6/16 15:16
 */
public class Spider {

    public static void main(String[] args) throws IOException {

        downloadHtml("https://www.baidu.com","./4.网络爬虫/src/img/www_baidu_com.html");

        //获取URL
        URL url = new URL("https://www.dianping.com");

        //下载资源 (字节网络流)
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null){
            sb.append(line+"\n");
        }
        br.close();
        System.out.println(sb.toString());
    }


    /**
     * 封装
     * @param url 网址
     * @param filePath 文件
     */
    public static void downloadHtml(String url, String filePath) {

        File fileName = new File(filePath);
        URL urlName;
        InputStream is = null;
        BufferedOutputStream os = null;
        try {
            urlName = new URL(url);
            is = urlName.openStream();
            os = new BufferedOutputStream(new FileOutputStream(fileName));

            byte[] flush = new byte[1024 * 50];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                    if (is != null){
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
