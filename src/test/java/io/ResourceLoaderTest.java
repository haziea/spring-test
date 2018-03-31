package io;

import org.junit.Assert;
import org.junit.Test;
import test.spring.core.io.Resource;
import test.spring.core.io.ResourceLoader;

import java.io.IOException;

public class ResourceLoaderTest {

    @Test
    public void test() throws IOException{
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        Assert.assertNotNull(resource.getInputStream());

    }
}
