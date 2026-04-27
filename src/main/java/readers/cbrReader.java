package readers;
import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import core.absCore;

public class cbrReader extends absCore {
    public cbrReader(String pth) {
        super(pth);
    }

    @Override
    public void openFile(File pth) {
        try(Archive archive= new Archive(pth)) {
            FileHeader header;
            while ((header=archive.nextFileHeader())!=null){
                if (!header.isDirectory()){
                    InputStream is=archive.getInputStream(header);

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
