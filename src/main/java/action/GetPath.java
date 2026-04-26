package action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPath {

    public Path getPath(String pth) {
        Path path= Paths.get(pth);
        try{
         Files.createDirectories(path);

        }catch(IOException e){
            e.printStackTrace();
        }


        return path;
    }
}
