package ru.rmanokhin.downloader;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * класс для загрузки в многопоточном режиме
 */
@Component
public class MultiThreadedDownloaderImpl implements MultiThreadedDownloader {
    /**
     * метод запускающий процесс скачивания файлов в многопоточном режиме
     */
    @Override
    public void startDownloading(int countThreads, int countUrls, List<String> urls, List<String> fileNames, int downloadSpeed) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);

        for (int i = 0; i < countUrls; i++) {
            executorService.submit(new Downloader(urls.get(i), fileNames.get(i), downloadSpeed));
        }

        executorService.shutdown();
    }


}
