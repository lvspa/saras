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
import java.util.List;

import javax.imageio.ImageIO;

public class cbrReader extends absCore {
    public cbrReader(String pth) {
        super(pth);
    }

    @Override
    public void openFile(File pth) {
        try(Archive archive= new Archive(pth)) {
            FileHeader header;
            final List<ContentDescription> contentFile= Junrar.getContentsDescription(pth);
            while ((header=archive.nextFileHeader())!=null){
                if (!header.isDirectory()){
                    InputStream is=archive.getInputStream(header);
                    BufferedImage img=null;
                    is.close();
                    try{
                        img=ImageIO.read(is);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (RarException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
