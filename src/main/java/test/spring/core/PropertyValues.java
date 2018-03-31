package test.spring.core;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PropertyValues {
    private @Getter final List<PropertyValue> propertyValueList = Lists.newArrayList();

    public void addPropertyValue(PropertyValue value){
        this.propertyValueList.add(value);
    }
}
