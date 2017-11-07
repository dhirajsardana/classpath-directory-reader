import edu.rs.poc.ClasspathDirManager;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class JarReaderTest {

    @Test
    public void readFromJarTest() throws IOException, URISyntaxException {
        new ClasspathDirManager().readFromJarAndCopy("target");
    }
}
