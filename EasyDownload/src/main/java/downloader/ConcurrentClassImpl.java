package downloader;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentClassImpl implements ConcurrentClass{

    @Override
    public void runThreads(String name, int countThreads, int countUrls) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        for (int i = 0; i < countUrls; i++) {
            try {
                executorService.submit(new DownloaderImpl(name + i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }


}
