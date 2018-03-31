package test.spring.core.aop;


import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 */
@Data
public class AdvisedSupport {

    //被代理对象
    private TargetSource targetSource;
    //方法拦截器
    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

}

