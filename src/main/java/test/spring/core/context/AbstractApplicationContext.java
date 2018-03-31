package test.spring.core.context;

import lombok.AllArgsConstructor;
import test.spring.core.factory.AbstractBeanFactory;

@AllArgsConstructor
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory abstractBeanFactory;

    public void refresh()throws Exception{}

    @Override
    public Object getBean(String name) throws Exception {
        return abstractBeanFactory.getBean(name);
    }
}
