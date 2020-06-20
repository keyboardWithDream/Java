package serlvet;

import Server.Request;
import Server.Response;

/**
 * 服务器小脚本接口
 * @Author: Harlan
 * @Date: 2020/6/20 23:01
 */
public interface Servlet {

    /**
     * 服务
     * @param request 请求
     * @param response 响应
     */
    void service(Request request, Response response);
}
