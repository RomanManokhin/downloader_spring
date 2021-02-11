package ru.rmanokhin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rmanokhin.downloader.*;
import ru.rmanokhin.menu.MainMenu;
import ru.rmanokhin.menu.MainMenuImpl;

@Configuration
public class DownloaderConfiguration {

    @Bean
    public MainMenu mainMenu() {
        return new MainMenuImpl();
    }

    @Bean
    public BootPreparation bootPreparation() {
        return new BootPreparationImpl();
    }

    @Bean
    public MultiThreadedDownloader multiThreadedDownloader(){
        return new MultiThreadedDownloaderImpl();
    }


}
