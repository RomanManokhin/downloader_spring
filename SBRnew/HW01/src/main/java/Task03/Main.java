package HW01.Task03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите температуру по цельсию для конвертирования : ");
        float c = in.nextFloat();

        System.out.println("В какую температуру конвертировать?\n 1 - Фаренгейт\n 2 - Кельвин\n 3 - Ранкин");
        int converter = in.nextInt();
        if (converter == 1 || converter == 2 || converter == 3) {
            switch (converter) {
                case 1:
                    System.out.println("Температура по Фаренгейту = " + Converter.fahrenheit(c));
                    break;
                case 2:
                    System.out.println("Температура по Кельвину = " + Converter.kelvin(c));
                    break;
                case 3:
                    System.out.println("Температура по Ранкину = " + Converter.rankineScale(c));
                    break;
            }
        } else {
            System.out.println("Вы сделали не верный выбор\n");
            Main.main(null);
        }
    }
}

