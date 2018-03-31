package test.spring.core.aop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractAopProxy implements AopProxy {
   protected AdvisedSupport advisedSupport;

}
