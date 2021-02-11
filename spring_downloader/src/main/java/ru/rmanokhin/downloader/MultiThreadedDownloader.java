package ru.rmanokhin.downloader;

import java.util.List;

public interface MultiThreadedDownloader {

    void startDownloading(int countThreads, int countUrls, List<String> urls, List<String> fileNames);

}
