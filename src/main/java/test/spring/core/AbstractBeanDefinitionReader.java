package test.spring.core;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.spring.core.io.ResourceLoader;

import java.util.Map;

@NoArgsConstructor
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private @Getter Map<String,BeanDefinition> registry;

    private @Getter ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = Maps.newHashMap();
        this.resourceLoader = resourceLoader;
    }


}
