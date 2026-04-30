package readers;
import com.github.junrar.Archive;
import com.github.junrar.ContentDescription;
import com.github.junrar.Junrar;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import core.absCore;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

public class cbrReader extends absCore {
    public cbrReader(String pth) {
        super(pth);
    }

    @Override
    public void openFile(File pth) {
        try(Archive archive= new Archive(pth)) {
            List<FileHeader> headers=archive.getFileHeaders();
            headers.sort(null);

            File tempDir= new File(System.getProperty("user.home") + "/Documents/tempFile");
            if (!tempDir.exists()){
                tempDir= new File("/Documents/tempFile");
            }
            final List<ContentDescription> contentFile= Junrar.getContentsDescription(pth);
            try{
                for (FileHeader header:headers){
                    if (!header.isDirectory()){
                        Junrar.extract(pth,tempDir);
                }
            }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (RarException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteFile() {

    }
    @Override
    public void close() throws Exception {

    }
}
