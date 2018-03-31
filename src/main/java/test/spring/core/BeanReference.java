package test.spring.core;

import lombok.Getter;
import lombok.Setter;

public class BeanReference {
    private @Getter @Setter String name;

    private @Getter @Setter Object bean;

    public BeanReference(String name ){
        this.name = name;
    }
}
