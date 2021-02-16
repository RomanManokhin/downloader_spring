package ru.rmanokhin.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import ru.rmanokhin.spring.DownloaderConfiguration;

import java.util.Scanner;

/**
 * Класс для получения данных от пользователя, что бы производить загрузку по его параметрам
 */
@Component
public class MainMenuImpl implements MainMenu {
    Scanner in = new Scanner(System.in);


    /**
     * метод для получения количества потоков скачивания от пользователя
     */
    @Override
    public int takeThreads() {
        while (true) {
            System.out.print("Enter the number of streams to download: ");
            String temp = in.next();

            try {
                int countThread = Integer.parseInt(temp);
                if (countThread > 0) {
                    return countThread;
                } else {
                    System.out.println("The number should be > 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("No number entered");
            }
        }
    }

    /**
     * метод для получения места хранения файла из которого необходимо брать ссылки для скачивания
     */
    @Override
    public String takePathFile() {
        while (true) {
            System.out.println("Use that - src/main/resources/info/data.txt");
            System.out.print("Enter file path: ");
            String pathFile = in.next();
            boolean checkExtension = pathFile.endsWith(".txt");
            if (checkExtension) {
                return pathFile;
            } else {
                System.out.println("File extension is not .txt\n");
            }
        }

    }

    /**
     * метод для получения скорости скачивания файлов
     */
    @Override
    public int downloadSpeed() {
        while (true) {
            System.out.print("Enter download speed in kb: ");
            String temp = in.next();

            try {
                int downloadSpeed = Integer.parseInt(temp);
                if (downloadSpeed >= 0 && downloadSpeed <= 1000) {
                    return downloadSpeed * 1024;
                } else {
                    System.out.println("Speed must be greater than 0kb and less than 1000kb");
                }
            } catch (NumberFormatException ex) {
                System.out.println("No number entered");
            }
        }
    }
}
