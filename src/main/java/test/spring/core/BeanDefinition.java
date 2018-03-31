package test.spring.core;

import lombok.Getter;
import lombok.Setter;

public class BeanDefinition {

    private @Getter @Setter Object bean;

    private @Getter @Setter Class beanClass;

    private @Getter String beanClassName;

    private @Getter @Setter PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition(){};

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public void setBeanClassName(String beanClassName){
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
