package test.spring.core.aop;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 被代理对象信息
 */
@Data
public class TargetSource {

    private Object target;
    private Class<?> targetClass;
    private Class<?>[] interfaces;
    public TargetSource(Object target,Class<?> targetClass,Class<?>... interfaces){
        this.target = target;
        this.interfaces = interfaces;
        this.targetClass = targetClass;
    }
}
