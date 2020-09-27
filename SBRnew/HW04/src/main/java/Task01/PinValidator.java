package Task01;

import java.util.Arrays;
import java.util.Scanner;

public class PinValidator {

    int[] realPassword = {1, 2, 3, 4};
    int[] testPassword = new int[4];
    Scanner in = new Scanner(System.in);

    int countForAccess = 0;
    int countForMaxWrongPIN = 0;
    int number = 0;
    boolean flag = false;
    public boolean access() {
        while (countForMaxWrongPIN < 3) {
            countForAccess = 0;
            while (countForAccess < 4) {
                System.out.print("Write number : ");
                String input = in.nextLine();
                try {
                    number = Integer.parseInt(input);
                    testPassword[countForAccess] = number;
                    countForAccess++;
                } catch (Exception e) {
                    System.out.println("Its not a number");
                }
            }

            boolean result = Arrays.equals(realPassword, testPassword);
            if (!result) {
                countForMaxWrongPIN++;
                if (countForMaxWrongPIN == 3) {
                    System.out.println("Wait 10 seconds");
                    flag = false;
                } else {
                    System.out.println("Wrong PIN");
                }

            } else {
                System.out.println("Pin is OK");
                flag = true;
                TerminalServer terminalServer = new TerminalServer();
                terminalServer.print();
                break;
            }

        }
        return flag;
    }
}
