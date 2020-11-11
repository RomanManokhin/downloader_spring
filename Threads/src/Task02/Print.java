package Task02;

import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.random;


public class Print {

    Random random = new Random();


    public void printPaperFire() {
        System.out.println("Бармен кладет на стол спички и бумагу.");
    }

    public void printPaperTabak() {
        System.out.println("Бармен кладет на стол табак и бумагу.");
    }

    public void printFireTabak() {
        System.out.println("Бармен кладет на стол табак и спички.");
    }

    public void printFire() {
        double x = (random(1) + 3);
        try {
            Thread.sleep((long) x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курильщик (спички) забирает табак и бумагу. Скручивает сигарету и курит (" + x + " с)");
    }

    public void printTabak() {
        double x = (random(1) + 3);
        try {
            Thread.sleep((long) x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курильщик (табак) забирает спички и бумагу. Скручивает сигарету и курит (" + x + " с)");
    }

    public void printPaper() {
        double x = (random(1) + 3);
        try {
            Thread.sleep((long) x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курильщик (табак) забирает спички и табак. Скручивает сигарету и курит (" + x + " с)");
    }
}
