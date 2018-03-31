package test.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是Spring内部定位资源的接口
 */
public interface Resource {
    public InputStream getInputStream () throws IOException;
}
