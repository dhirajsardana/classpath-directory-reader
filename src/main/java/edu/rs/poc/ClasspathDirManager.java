package edu.rs.poc;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

//Read directory from clas path and copies to given location.
public class ClasspathDirManager {

    public void readFromJarAndCopy(String destParentPath) throws URISyntaxException, IOException {
        String resourceDirPath = "resDir";
        File destFile = new File(destParentPath, resourceDirPath);
        destFile.mkdir();
        URI uri = this.getClass().getClassLoader().getResource(resourceDirPath).toURI();
        Map<String, Object> env = new HashMap<>();
        Path baseDirPath = null;
        try(FileSystem fs = FileSystems.newFileSystem(uri, env)){
            baseDirPath = fs.provider().getPath(uri);
            //call copy here , otherwise fs will be closed outside try block.
            copy(baseDirPath, destFile.toString());
        }catch(Exception e){
            //In test cases , its getting exception so providing direct resource path.
            baseDirPath = Paths.get("src/main/resources",resourceDirPath);
            copy(baseDirPath, destFile.toString());
        }

    }

    // Copy recursively.
    private void copy(Path path, String destPath) throws IOException {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for(Path pathStream : stream){
                if(!Files.isDirectory(pathStream)){
                    Files.copy(pathStream, Paths.get(destPath, pathStream.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                } else{
                    File dir = new File(destPath, pathStream.getFileName().toString());
                    dir.mkdir();
                    copy(pathStream, dir.toString());
                }

            }
        }
    }
}
