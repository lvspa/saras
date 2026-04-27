package core;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class absCore implements AutoCloseable{
    protected Path path;
    public absCore(String pth){
        this.path=Paths.get(pth);

    }

    public abstract void openFile(File pth);
    public abstract void deleteFile();

}
