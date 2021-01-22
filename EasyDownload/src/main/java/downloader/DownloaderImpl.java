package downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DownloaderImpl implements Runnable {

    private final List<String> urls = new DownloadableFileImpl().getUrlFromFile();

    String name;
    int count = -1;

    public DownloaderImpl(String name) throws IOException {
        this.name = name;
        count++;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            FileUtils.copyURLToFile(new URL(urls.get(count)), new File("c:/" + name + ".mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " finished");
    }


}

