package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 封装请求协议
 * 获取method URI 以及请求参数
 * @Author: Harlan
 * @Date: 2020/6/20 18:44
 */
public class Request {

    private String requestInfo;
    private String method;
    private String url;
    private String queryStr;

    public Request(InputStream is){
        byte[] data = new byte[1024 * 1024];
        try {
            int dataLen = is.read(data);
            requestInfo = new String(data,0,dataLen);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    /**
     * 分解请求信息
     * 拆分字符串
     */
    private void parseRequestInfo(){
        final String POST = "post";
        final String QM = "?";
        final String CRLF = "\r\n";
        System.out.println("====分解开始====");
        System.out.println(requestInfo);
        method = requestInfo.substring(0,requestInfo.indexOf("/")).trim().toLowerCase();
        url = requestInfo.substring(requestInfo.indexOf("/")+1,requestInfo.indexOf("HTTP/"));
        //分解参数和url
        if (url.indexOf(QM) >= 0){
            String[] urlArr = url.split("\\?");
            url = urlArr[0];
            queryStr = urlArr[1];
        }
        if (method.equals(POST)){
            String qStr = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
            if (queryStr == null){
                queryStr = qStr;
            }else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = null == queryStr ? "":queryStr;
        System.out.println(method+"--->"+url+"--->"+queryStr);
    }
}
