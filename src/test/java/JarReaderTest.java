import edu.rs.poc.ClasspathDirManager;

import java.io.IOException;
import java.net.URISyntaxException;

public class JarReaderTest {

    //@Test
    public void readFromJarTest() throws IOException, URISyntaxException {
        new ClasspathDirManager().readFromJarAndCopy("target");
    }
}
