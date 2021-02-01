package downloader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedDownloaderImpl implements MultiThreadedDownloader {

    @Override
    public void startDownloading(int countThreads, int countUrls, List<String> urls, List<String> fileNames) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);

        for (int i = 0; i < countUrls; i++) {
            executorService.submit(new DownloaderImpl(urls.get(i), fileNames.get(i)));
        }

        executorService.shutdown();
    }


}
