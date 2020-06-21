package servlet;

import parsing.WebContext;
import parsing.WebHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @Author: Harlan
 * @Date: 2020/6/20 23:39
 */
public class WebApp {

    private static WebContext webContext;

    static {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            WebHandler handler = new WebHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),handler);
            //提交数据给webContext处理
            webContext = new WebContext(handler.getEntityList(), handler.getMappingList());
        }catch (Exception e){
            System.out.println("解析文件错误...");
            e.printStackTrace();
        }
    }

    /**
     * 通过 url 获取配置文件对应的servlet
     * @param url url
     * @return servlet
     */
    public static Servlet getServletFromUrl(String url){
        String clzName = webContext.getClz("/"+url);
        try {
            Class clz = Class.forName(clzName);
            Servlet servlet = (Servlet)clz.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            System.out.println("创建Servlet错误...");
            e.printStackTrace();
        }
        return null;
    }
}
