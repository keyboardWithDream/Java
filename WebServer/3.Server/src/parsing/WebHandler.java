package parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Harlan
 * @Date: 2020/6/19 22:25
 */
public class WebHandler extends DefaultHandler {

    private final String SERVLET_NAME = "servlet-name";
    private final String SERVICE_CLASS = "servlet-class";
    private final String URL_PATTERN = "url-pattern";
    private final String SERVLET_MAPPING = "servlet-mapping";
    private final String SERVLET = "servlet";

    private Entity entity;
    private Mapping mapping;
    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private String tag;
    private boolean isMapping = false;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        entityList = new ArrayList<>();
        mappingList = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName != null) {
            tag = qName;
            if (tag.equals(SERVLET)) {
                isMapping = false;
                entity = new Entity();
            } else if (tag.equals(SERVLET_MAPPING)) {
                isMapping = true;
                mapping = new Mapping();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch, start, length).trim();
        if (tag != null && contents.length() > 0) {
            if (isMapping) {
                if (tag.equals(SERVLET_NAME)) {
                    mapping.setName(contents);
                } else if (tag.equals(URL_PATTERN)) {
                    mapping.addPattern(contents);
                }
            } else {
                if (tag.equals(SERVLET_NAME)) {
                    entity.setName(contents);
                } else if (tag.equals(SERVICE_CLASS)) {
                    entity.setClz(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName != null) {
            if (qName.equals(SERVLET)) {
                entityList.add(entity);
            } else if (qName.equals(SERVLET_MAPPING)) {
                mappingList.add(mapping);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }

}
