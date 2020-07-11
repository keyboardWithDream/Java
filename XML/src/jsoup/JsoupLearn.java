package jsoup;

import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import cn.wanghaomiao.xpath.model.JXDocument;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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

        //网络资源解析
        URL url = new URL("https://www.baidu.com");
        Document documentBaidu = Jsoup.parse(url, 5000);
        System.out.println(documentBaidu.html());

        System.out.println("======================================");

        //XPath查询
        JXDocument jxDocument = new JXDocument(document);
        //查询语法
        List<JXNode> jxNodeList = jxDocument.selN("//name");
        for (JXNode jxNode : jxNodeList) {
            System.out.println(jxNode);
        }
    }
}
