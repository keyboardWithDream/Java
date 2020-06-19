package xml_parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 熟悉SAX解析流程
 * 1.获取解析工程
 * 2.从工厂获取解析器
 * 3.加载文档Document 注册处理器
 * 4.编写处理器
 * @Author: Harlan
 * @Date: 2020/6/19 16:37
 */
public class XmlSax {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //SAX解析

        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //2.从工厂获取解析器
        SAXParser parser = factory.newSAXParser();

        //3.编写处理器
        //personsHandler

        //4.加载文档Document注册处理器
        PersonsHandler handler = new PersonsHandler();

        //5.解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xml_parsing/persons.xml"),handler);

        //分析数据
        List<Person> persons = handler.getPersonsList();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}

/**
 * 编写处理器
 */
class PersonsHandler extends DefaultHandler{

    private final String PERSON_ = "person";
    private final String NAME_ = "name";
    private final String AGE_ = "age";

    //创建容器
    private List<Person> personsList;
    //创建对象
    private Person person;
    //存储标签名
    private String tag;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("====解析文档开始====");
        //初始化
        personsList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(qName + "--->解析开始");
        //存储标签
        if (null!=qName){
            tag = qName;
            //创建对象
            if (tag.equals(PERSON_)){
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length).trim();
        if (tag != null){
            if (tag.equals(NAME_)){
                person.setName(contents);
            }else if (tag.equals(AGE_)){
                if (contents.length() > 0){
                    person.getAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println(qName + "--->解析结束");
        //加入容器
        if (qName.equals("person")) {
            personsList.add(person);
        }
        //丢弃标签
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("====解析文档结束====");
    }

    public List<Person> getPersonsList() {
        return personsList;
    }
}