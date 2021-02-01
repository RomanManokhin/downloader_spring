package main;

import downloader.BootPreparationImpl;
import downloader.MultiThreadedDownloaderImpl;
import menu.MainMenuImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MainMenuImpl menu = new MainMenuImpl();
        String pathFile = menu.takePathFile();
        int countThreads = menu.takeThreads();

        BootPreparationImpl bootPreparation = new BootPreparationImpl();
        List<String> urls = bootPreparation.parsingFileForUrls(pathFile);
        List<String> fileNames = bootPreparation.parsingFileForNames(urls);

        MultiThreadedDownloaderImpl downloader = new MultiThreadedDownloaderImpl();
        downloader.startDownloading(countThreads, urls.size(), urls, fileNames);


    }
}
