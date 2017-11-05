import edu.rs.poc.JarReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class JarReaderTest {

    @Test
    public void readFromJarTest() throws IOException, URISyntaxException {
        new JarReader().readingFromJar();
    }
}
