package menu;

import java.util.Scanner;

public class MainMenuImpl implements MainMenu {
    Scanner in = new Scanner(System.in);
    int countThread;

    @Override
    public String takeName() {
        System.out.print("Enter file name: ");
        return in.next();
    }

    @Override
    public int takeThreads() {
        while (true) {
            System.out.print("Enter the number of streams to download: ");
            String s = in.next();
            try {
                countThread = Integer.parseInt(s);
                if(countThread >= 0) {
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
        System.out.println("Use that - src/main/resources/info/data.txt");
        System.out.print("Enter file path: ");
        return in.nextLine();
    }
}
