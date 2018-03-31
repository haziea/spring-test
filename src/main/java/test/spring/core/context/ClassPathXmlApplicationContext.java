package test.spring.core.context;

import test.spring.core.BeanDefinition;
import test.spring.core.factory.AbstractBeanFactory;
import test.spring.core.factory.AutowireCapableBeanFactory;
import test.spring.core.io.ResourceLoader;
import test.spring.core.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation)throws Exception{
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory)throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistry().entrySet()) {
            abstractBeanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

    }

}
