package downloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DownloadableFileImpl implements DownloadableFile{

    @Override
    public List<String> getUrlFromFile() {
        List<String> urls = null;
        try {
            urls = Files.readAllLines(Paths.get("src/main/resources/info/data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }
}
