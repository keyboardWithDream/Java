package url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL: 统一资源定位器 - 区分资源
 * 组成: 1.协议 2.域名 3.端口 4.请求资源
 * @Author: Harlan
 * @Date: 2020/6/16 14:52
 */
public class Url {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://www.baidu.com:80/index.html?uname=harlan&age=24#a");
        //获取四个值
        System.out.println("协议: " + url.getProtocol());
        System.out.println("域名: " + url.getHost());
        System.out.println("端口: "+url.getPort());
        System.out.println("请求静态资源: "+url.getPath());
        System.out.println("请求资源: "+url.getFile());

        System.out.println("===========");
        //参数
        System.out.println("参数: "+url.getQuery());
        //锚点
        System.out.println("锚点: "+url.getRef());
    }
}
