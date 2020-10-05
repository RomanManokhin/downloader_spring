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
//    boolean flagForThreeFault = false;
    boolean result = true;
    public void access() throws InterruptedException {
        while (countForMaxWrongPIN < 4) {
            countForAccess = 0;
            while (countForAccess < 4) {
                if (!result) {
                    result = true;
                    countForAccess = 0;
                    if (countForMaxWrongPIN == 3) {
                        System.out.println("Wait 10 seconds");
                        Thread.sleep(10000);
                    } else {
                        System.out.println("Wrong PIN");
                    }
                }
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

            result = Arrays.equals(realPassword, testPassword);
            countForMaxWrongPIN++;
            if(result) {
                System.out.println("Pin is OK");
                TerminalServer terminalServer = new TerminalServer();
                terminalServer.print();
            }
//            if (!result) {
//                if (countForMaxWrongPIN == 3) {
//                    System.out.println("Wait 10 seconds");
//                    Thread.sleep(10000);
//                    flagForThreeFault = false;
//                } else {
//                    System.out.println("Wrong PIN");
//                }
//            } else {
//                System.out.println("Pin is OK");
//                flagForThreeFault = true;
//                TerminalServer terminalServer = new TerminalServer();
//                terminalServer.print();
//            }
        }
    }
}
