package servlet;

import org.xml.sax.SAXException;
import servlet.parsing.Entity;
import servlet.parsing.Mapping;
import servlet.parsing.WebContext;
import servlet.parsing.WebHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author: Harlan
 * @Date: 2020/6/19 20:32
 */
public class ServletParsing {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        WebHandler handler = new WebHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("servlet/parsing/web.xml"),handler);

        //打印测试
        List<Entity> entityList = handler.getEntityList();
        List<Mapping> mappingList = handler.getMappingList();

        /**
         * 打印测试
         */
        for (Entity entity : entityList) {
            System.out.println(entity.toString());
        }

        System.out.println("=======================");

        for (Mapping mapping : mappingList) {
            System.out.println(mapping.toString());
        }

        System.out.println("=======================");

        //提交数据给webContext处理
        WebContext webContext = new WebContext(handler.getEntityList(), handler.getMappingList());


        //得到反射类
        String clzName = webContext.getClz("/g");
        Class clz = Class.forName(clzName);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        servlet.service();


        clzName = webContext.getClz("/reg");
        clz = Class.forName(clzName);
        servlet = (Servlet)clz.getConstructor().newInstance();
        servlet.service();
    }
}
