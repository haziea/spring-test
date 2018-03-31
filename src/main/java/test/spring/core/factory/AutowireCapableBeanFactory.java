package test.spring.core.factory;

import test.spring.core.BeanDefinition;
import test.spring.core.BeanReference;
import test.spring.core.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
      Object bean = createBean(beanDefinition);
      beanDefinition.setBean(bean);
      applyPropertyValues(bean,beanDefinition);
      return bean;
    }


    public Object createBean (BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean ,BeanDefinition de) throws Exception{
        for (PropertyValue propertyValue: de.getPropertyValues().getPropertyValueList()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                value = getBean(((BeanReference) value).getName());
            }
            field.set(bean,value);
        }
    }

}
