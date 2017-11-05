package edu.rs.poc;

import org.apache.commons.io.FileUtils;
import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JarReader {

    public void readingFromJar() throws URISyntaxException, IOException {
        /*List<String> data =  Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("res.txt").toURI()), Charset.defaultCharset());
        System.out.println(data.get(0));*/

        //InputStream in = this.getClass().getResourceAsStream("/res.txt");
        //byte[] data = new byte[1000];
        //in.read(data);
        //System.out.println(data);

        String pathName = "resDir";
        File destFile = new File("target", pathName);
        destFile.mkdir();
        URI uri = this.getClass().getClassLoader().getResource(pathName).toURI();
        Map<String, Object> env = new HashMap<>();
        try(FileSystem fs = FileSystems.newFileSystem(uri, env)){
            Path baseDirPath = fs.provider().getPath(uri);
            print(baseDirPath, destFile.toString());
        }

    }

    private void print(Path path, String destPath) throws IOException {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for(Path pathStream : stream){
                if(!Files.isDirectory(pathStream)){
                    Files.copy(pathStream, Paths.get(destPath, pathStream.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                } else{
                    File dir = new File(destPath, pathStream.getFileName().toString());
                    dir.mkdir();
                    print(pathStream, dir.toString());
                }

            }
        }
    }
}
