package ru.rmanokhin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rmanokhin.downloader.BootPreparation;
import ru.rmanokhin.downloader.BootPreparationImpl;
import ru.rmanokhin.downloader.MultiThreadedDownloader;
import ru.rmanokhin.downloader.MultiThreadedDownloaderImpl;
import ru.rmanokhin.menu.MainMenu;
import ru.rmanokhin.menu.MainMenuImpl;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DownloaderConfiguration.class);

        MainMenu menu = applicationContext.getBean("mainMenu",
                MainMenu.class);
        String pathFile = menu.takePathFile();
        int countThreads = menu.takeThreads();
        int downloadSpeed = menu.downloadSpeed();

        BootPreparation boot = applicationContext.getBean("bootPreparation",
                BootPreparation.class);
        List<String> urls = boot.parsingFileForUrls(pathFile);
        List<String> fileNames = boot.parsingFileForNames(urls);

        MultiThreadedDownloader downloader = applicationContext.getBean("multiThreadedDownloader",
                MultiThreadedDownloader.class);

        downloader.startDownloading(countThreads, urls.size(), urls, fileNames, downloadSpeed);
    }

}
