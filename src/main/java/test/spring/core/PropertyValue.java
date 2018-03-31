package test.spring.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PropertyValue {
    private final String name;
    private final Object value;
}
