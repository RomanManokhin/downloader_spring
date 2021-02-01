package menu;

import java.util.Scanner;

public class MainMenuImpl implements MainMenu {
    Scanner in = new Scanner(System.in);
    int countThread;

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

    @Override
    public String takePathFile() {
        while (true) {
            System.out.println("Use that - src/main/resources/info/data.txt");
            System.out.print("Enter file path: ");
            String pathFile = in.next();
            boolean extensionСheck = pathFile.endsWith(".txt");
            if (extensionСheck) {
                return pathFile;
            } else {
                System.out.println("File extension is not .txt\n");
            }
        }

    }
}
