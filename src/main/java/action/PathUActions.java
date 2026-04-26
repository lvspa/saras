package action;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUActions {
    public Path getPath(String pth) {
        Path path=Paths.get(pth);
        try{
            Files.createDirectories(path);

        }catch(IOException e){
            e.printStackTrace();
        }


        return path;
    }
    public void openPath(String pth){
        Path path=Paths.get(pth);
        try {
            Files.op
        }


    }

}
