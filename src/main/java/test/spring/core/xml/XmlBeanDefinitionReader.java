package test.spring.core.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import test.spring.core.AbstractBeanDefinitionReader;
import test.spring.core.BeanDefinition;
import test.spring.core.BeanReference;
import test.spring.core.PropertyValue;
import test.spring.core.io.ResourceLoader;
import test.spring.core.utils.StringUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream)throws Exception{
        DocumentBuilderFactory documentBuilderFactory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    protected void registerBeanDefinitions(Document document){
        Element root =  document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root){
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element element = (Element)node;
                processBeanDefinitions(element);

            }
        }
    }

    protected void processBeanDefinitions(Element element){
       String name =  element.getAttribute("name");
       String className = element.getAttribute("class");
       BeanDefinition beanDefinition = new BeanDefinition();
       beanDefinition.setBeanClassName(className);
       processPropery(element,beanDefinition);
       getRegistry().put(name,beanDefinition);
    }

    private void processPropery(Element element,BeanDefinition beanDefinition){
        NodeList nodeList = element.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength() ; i++) {
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element ele = (Element)node;
                String name = ele.getAttribute("name");
                String value = ele.getAttribute("value");
                if(StringUtil.isNotEmpty(value)){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    String ref = ele.getAttribute("ref");
                    if(StringUtil.isEmpty(ref)){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }

        }

    }

}
