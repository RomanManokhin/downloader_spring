package downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloaderImpl implements Downloader{


    private final String fileUrl;
    private final String fileName;


    public DownloaderImpl(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");

        try {
            FileUtils.copyURLToFile(new URL(fileUrl), new File("c:/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " finished");
    }



}

