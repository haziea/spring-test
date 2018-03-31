package test.spring.core.factory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import test.spring.core.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = Maps.newConcurrentMap();

    private final List<String> beanDefinitionNames = Lists.newArrayList();

    @Override
    public Object getBean(String name)throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons()throws Exception{
        for(Iterator it = this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean (BeanDefinition beanDefinition) throws Exception ;

    public List getBeansForType(Class type) throws Exception{
       List beans = Lists.newArrayList();
        for (String beanName:beanDefinitionNames) {
            if(type.isAssignableFrom(beanDefinitionMap.get(beanName).getBeanClass())){
                beans.add(getBean(beanName));
            }
        }
       return beans;
    }
}
