package edu.rs.poc;

import java.io.IOException;
import java.net.URISyntaxException;

public class ClasspathDirManagerMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String destPath = "target";
        if(args!=null && args.length>0 && args[0]!=null){
            destPath = args[0];
        }
        new ClasspathDirManager().readFromJarAndCopy(destPath);
    }
}
