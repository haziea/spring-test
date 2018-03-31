package test.spring.core.aop;

import org.aopalliance.intercept.MethodInterceptor;
import test.spring.core.BeanPostProcessor;
import test.spring.core.factory.AbstractBeanFactory;
import test.spring.core.factory.BeanFactory;

import java.util.List;

public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware{

    private AbstractBeanFactory beanFactory;

    private List<AspectJExpressionPointcutAdvisor> advisors;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        if(bean instanceof AspectJExpressionPointcutAdvisor){return bean;}
        if(bean instanceof MethodInterceptor){return bean;}
        advisors = getAdvisor();
        for (AspectJExpressionPointcutAdvisor advisor:advisors) {
            if(advisor.getPointcut().getClassFilter().matches(bean.getClass())){
                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setTargetSource(new TargetSource(bean,bean.getClass(),bean.getClass().getInterfaces()));
                advisedSupport.setMethodInterceptor((MethodInterceptor)advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                return new JdkDynamicAopProxy(advisedSupport);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {

    }

    private List getAdvisor() throws Exception{
        if(advisors!=null&&advisors.size()>0){
            return advisors;
        }
        advisors = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
        return advisors;
    }

}
