package ru.rmanokhin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rmanokhin.spring.downloader.BootPreparation;
import ru.rmanokhin.spring.downloader.MultiThreadedDownloader;
import ru.rmanokhin.spring.menu.MainMenu;

import java.util.List;

@Component
public class StartProgram {

    private final MainMenu mainMenu;
    private final BootPreparation bootPreparation;
    private final MultiThreadedDownloader multiThreadedDownloader;


    public StartProgram(MainMenu mainMenu, BootPreparation bootPreparation, MultiThreadedDownloader multiThreadedDownloader) {
        this.mainMenu = mainMenu;
        this.bootPreparation = bootPreparation;
        this.multiThreadedDownloader = multiThreadedDownloader;
    }

    /**
     * Метод для запуск программы
     * */
    public void start() {

        String pathFile = mainMenu.takePathFile();
        int countThreads = mainMenu.takeThreads();
        int downloadSpeed = mainMenu.downloadSpeed();

        List<String> urls = bootPreparation.parsingFileForUrls(pathFile);
        List<String> fileNames = bootPreparation.parsingListUrlsForNames(urls);

        multiThreadedDownloader.startDownloading(countThreads, urls.size(), urls, fileNames, downloadSpeed);
    }
}
