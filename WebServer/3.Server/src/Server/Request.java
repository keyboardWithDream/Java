package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

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
    private Map<String, List<String>> parameterMap;

    public Request(InputStream is){
        parameterMap = new HashMap<>();
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
        method = requestInfo.substring(0,requestInfo.indexOf("/")).trim().toLowerCase();
        url = requestInfo.substring(requestInfo.indexOf("/")+1,requestInfo.indexOf("HTTP/")).trim();
        //分解参数和url
        if (url.indexOf(QM) >= 0){
            String[] urlArr = url.split("\\?");
            url = urlArr[0].trim();
            queryStr = urlArr[1].trim();
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

        //将请求参数转换为Map
        convertMap(queryStr);
    }

    /**
     * 将请求参数转换成Map
     */
    private void convertMap(String queryStr){
        String[] keyValue = queryStr.split("&");
        for (String s : keyValue) {
            String[] kv = s.split("=");
            //避免空值,添加长度
            kv = Arrays.copyOf(kv,2);
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1],"utf-8");
            //如果key为第一次出现则创建容器
            if (!parameterMap.containsKey(key)){
                parameterMap.put(key, new ArrayList<String>());
            }
            //添加value
            parameterMap.get(key).add(value);
        }
    }

    /**
     *通过 key 获取多个 value
     * @param key key
     * @return value 数组
     */
    public String[] getParameterValues(String key){
        List<String> valueList = parameterMap.get(key);
        if (valueList == null || valueList.size() < 1){
            String[] strArr = {"null","null"};
            return strArr;
        }
        //转换类型成String[]
        return valueList.toArray(new String[0]);
    }

    /**
     * 通过key 获取一个 value
     * @param key key
     * @return 返回一个value
     */
    public String getParameterValue(String key){
        return getParameterValues(key)[0];
    }

    /**
     * 处理中文
     * @return 中文字符
     */
    private String decode(String value, String enc){
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMethod() {
        return method;
    }


    public String getUrl() {
        return url;
    }


    public String getQueryStr() {
        return queryStr;
    }

}
