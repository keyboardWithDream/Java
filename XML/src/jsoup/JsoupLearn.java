package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Harlan
 * @date 2020/7/11 22:13
 */
public class JsoupLearn {

    public static void main(String[] args) throws IOException {
        //1.导包(已完成)
        //2.获取Document对象，根据xml文档获取
        //2.1获取xml文件路径
        String path = (Objects.requireNonNull(JsoupLearn.class.getClassLoader().getResource("student.xml"))).getPath();
        //2.2解析xml文档，加载文档进内存，获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2获取数据
        String name = element.text();
        System.out.println(name);
    }
}
