package Server;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装响应协议
 * @Author: Harlan
 * @Date: 2020/6/20 16:47
 */
public class Response {

    private BufferedWriter bw;
    private StringBuilder content;
    private StringBuilder headInfo;
    private int contentLength;
    private final String BLANK = " ";
    private final String CRLF = "\r\n";

    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
            e.printStackTrace();
        }
    }

    public Response(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    /**
     * 动态添加内容
     * @param info 内容信息
     * @return 自身内容
     */
    public Response print(String info){
        content.append(info);
        contentLength += info.getBytes().length;
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        contentLength += (CRLF+info).getBytes().length;
        return this;
    }


    /**
     * 创建头信息
     * @param code 状态码
     */
    private void crateHeadInfo(int code){
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
            default:
                break;
        }

        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("localhost").append(CRLF);
        headInfo.append("Content-type:").append("text/html;charset=utf-8").append(CRLF);
        headInfo.append("Content-length:").append(contentLength).append(CRLF);
        headInfo.append(CRLF);
    }

    /**
     * 推送响应信息
     * @param code 状态码
     */
    public void pushToBrowser(int code){
        if (headInfo == null){
            code = 505;
        }

        crateHeadInfo(code);
        try {
            bw.append(headInfo);
            bw.append(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
