package ru.rmanokhin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.rmanokhin.downloader.BootPreparation;
import ru.rmanokhin.downloader.MultiThreadedDownloader;
import ru.rmanokhin.menu.MainMenu;

import java.util.List;

//@SpringBootApplication
@ComponentScan
public class Application {

    private static MainMenu mainMenu;
    private static BootPreparation bootPreparation;
    private static MultiThreadedDownloader multiThreadedDownloader;


    //    public Application(MainMenu mainMenu, BootPreparation bootPreparation, MultiThreadedDownloader multiThreadedDownloader) {
//        this.mainMenu = mainMenu;
//        this.bootPreparation = bootPreparation;
//        this.multiThreadedDownloader = multiThreadedDownloader;
//    }
    @Autowired
    public void setMainMenu(MainMenu mainMenu) {
        Application.mainMenu = mainMenu;
    }

    @Autowired
    public void setBootPreparation(BootPreparation bootPreparation) {
        Application.bootPreparation = bootPreparation;
    }

    @Autowired
    public void setMultiThreadedDownloader(MultiThreadedDownloader multiThreadedDownloader) {
        Application.multiThreadedDownloader = multiThreadedDownloader;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DownloaderConfiguration.class);

//        MainMenu menu = applicationContext.getBean("mainMenu",
//                MainMenu.class);
        String pathFile = mainMenu.takePathFile();
        int countThreads = mainMenu.takeThreads();
        int downloadSpeed = mainMenu.downloadSpeed();

//        BootPreparation boot = applicationContext.getBean("bootPreparation",
//                BootPreparation.class);
        List<String> urls = bootPreparation.parsingFileForUrls(pathFile);
        List<String> fileNames = bootPreparation.parsingListUrlsForNames(urls);

//        MultiThreadedDownloader downloader = applicationContext.getBean("multiThreadedDownloader",
//                MultiThreadedDownloader.class);

        multiThreadedDownloader.startDownloading(countThreads, urls.size(), urls, fileNames, downloadSpeed);
    }

}
