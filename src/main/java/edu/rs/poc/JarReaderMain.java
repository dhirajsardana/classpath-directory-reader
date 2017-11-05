package edu.rs.poc;

import java.io.IOException;
import java.net.URISyntaxException;

public class JarReaderMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        new JarReader().readingFromJar();
    }
}
