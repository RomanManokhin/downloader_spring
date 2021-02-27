package ru.rmanokhin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rmanokhin.spring.downloader.MultiThreadedDownloaderImpl;
import ru.rmanokhin.spring.menu.MainMenu;
import ru.rmanokhin.spring.menu.MainMenuImpl;
import ru.rmanokhin.spring.starter.StartProgramImpl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Application {

    private static StartProgramImpl startProgramImpl;

    @Autowired
    public void setStart(StartProgramImpl startProgramImpl) {
        Application.startProgramImpl = startProgramImpl;
    }
//    private static MultiThreadedDownloaderImpl multiThreadedDownloaderImpl;
//
//    @Autowired
//    public void test(MultiThreadedDownloaderImpl multiThreadedDownloaderImpl) {
//        Application.multiThreadedDownloaderImpl = multiThreadedDownloaderImpl;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        MultiThreadedDownloaderImpl multiThreadedDownloader = new MultiThreadedDownloaderImpl();
        startProgramImpl.start();



//        MainMenuImpl mainMenu = new MainMenuImpl();
//        int x = mainMenu.menuCountThreads();
//        String y = mainMenu.menuPathDownload();
//        String x = mainMenu.menuTakePathFile();
//
//
//        System.out.println(x);
//        System.out.println(y);

//        int testCountThreads = 3;
//        int testCountUrls = 5;
//        int testDownloadSpeed = 500;
//        String testFolderForDownload = "C:\\testMusic";
//
//        List<String> testFileNames = Arrays.asList("Mjevl_-_KHolodok_67381798.mp3"
//                , "Ruki_Vverkh_Oksana_Pochepa_-_Tolko_dlya_tebya_72239067.mp3"
//                , "Raim_-_Dvigatsya_63406775.mp3"
//                , "SAINt_JHN_Imanbek_-_Roses_66582659.mp3"
//                , "Artik_Asti_-_Vse_mimo_68289046.mp3");
//
//        List<String> testUrlList = Arrays.asList(
//                "https://ruv.hotmo.org/get/music/20191123/Mjevl_-_KHolodok_67381798.mp3"
//                , "https://ruv.hotmo.org/get/music/20210108/Ruki_Vverkh_Oksana_Pochepa_-_Tolko_dlya_tebya_72239067.mp3"
//                , "https://ruv.hotmo.org/get/music/20190410/Raim_-_Dvigatsya_63406775.mp3"
//                , "https://ruv.hotmo.org/get/music/20190915/SAINt_JHN_Imanbek_-_Roses_66582659.mp3"
//                , "https://ruv.hotmo.org/get/music/20200207/Artik_Asti_-_Vse_mimo_68289046.mp3");
//
//        multiThreadedDownloader.startDownloading(testCountThreads, testCountUrls, testUrlList, testFileNames, testDownloadSpeed, testFolderForDownload);

    }

}
