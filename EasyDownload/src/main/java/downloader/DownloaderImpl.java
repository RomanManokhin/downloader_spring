package downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloaderImpl implements Runnable {

    private final List<String> urls = new DownloadableFileImpl().getUrlFromFile();
    private static final AtomicInteger count = new AtomicInteger(-1);
    String name;
    int idName;

    public DownloaderImpl(String name) throws IOException {
        this.name = name;
        idName = count.incrementAndGet();
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            FileUtils.copyURLToFile(new URL(urls.get(idName)), new File("c:/" + name + ".mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " finished");
    }



}

