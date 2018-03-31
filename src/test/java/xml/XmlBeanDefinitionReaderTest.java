package xml;

import junit.framework.Assert;
import org.junit.Test;
import test.spring.core.io.ResourceLoader;
import test.spring.core.xml.XmlBeanDefinitionReader;

public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Assert.assertTrue(xmlBeanDefinitionReader.getRegistry().size()==1);

    }
}
