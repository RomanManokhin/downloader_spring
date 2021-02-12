package ru.rmanokhin.menu;

import java.util.Scanner;

public class MainMenuImpl implements MainMenu {
    Scanner in = new Scanner(System.in);
    int countThread;
    /**
     * метод для получения количества потоков скачивания от пользователя
     * */
    @Override
    public int takeThreads() {
        while (true) {
            System.out.print("Enter the number of streams to download: ");
            String temp = in.next();
            try {
                countThread = Integer.parseInt(temp);
                if (countThread >= 0) {
                    return countThread;
                } else {
                    System.out.println("The number should be >= 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("No number entered");
            }
        }
    }

    /**
     * метод для получения места хранения файла из которого необходимо брать ссылки
     * */
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

    @Override
    public int downloadSpeed() {
        while (true) {
            System.out.print("enter download speed in kb: ");
            String temp = in.next();
            try {
                countThread = Integer.parseInt(temp);
                if (countThread >= 0 && countThread <= 1000) {
                    return countThread * 1024;
                } else {
                    System.out.println("Speed must be greater than 0kb and less than 1000kb");
                }
            } catch (NumberFormatException ex) {
                System.out.println("No number entered");
            }
        }
    }
}
