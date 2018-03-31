package test.spring.core.factory;

import test.spring.core.BeanDefinition;

public interface BeanFactory {
    Object getBean (String name) throws Exception;
}
