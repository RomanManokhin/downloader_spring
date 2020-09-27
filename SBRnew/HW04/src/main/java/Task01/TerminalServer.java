package Task01;

import java.util.Scanner;

public class TerminalServer {
    Scanner in = new Scanner(System.in);
    TerminalImpl t = new TerminalImpl();
    boolean firstChoice = true;
    int money;

    void print() {
        while (true) {
            if (firstChoice) {
                System.out.println("What do you want to do?");
                firstChoice = false;
            } else {
                System.out.println("Do you want to do anything else?");
            }
            System.out.println("1 : Check account status");
            System.out.println("2 : Withdraw money");
            System.out.println("3 : Put money");
            System.out.println("4 : Return card");
            switch (in.next()) {
                case "1": {
                    t.checkAccountStatus();
                    break;
                }
                case "2": {
                    System.out.println("How much should you withdraw?");
                    money = in.nextInt();
                    if (money % 100 == 0) {
                        t.withDrawMoney(money);
                    } else {
                        System.out.println("Enter the amount in multiples of 100");
                    }
                    break;
                }
                case "3": {
                    System.out.println("How much should you deposit?");
                    money = in.nextInt();
                    if (money % 100 == 0) {
                        t.withPutMoney(money);
                    } else {
                        System.out.println("Enter the amount in multiples of 100");
                    }
                    break;
                }
                case "4":
                    System.out.println("Thank you for using our service");
                    System.exit(0);
                default:
                    System.out.println("Choose one of the options offered");
            }
        }
    }
}
