import java.util.*;

public class Discount {

    public void printDiscount() {
        System.out.println("Доступные акции: ");
        DiscountNewYear.printNewYear();
        DiscountManDay.printManDay();
        DiscountWomanDay.printWomanDay();
    }

    public void deleteAction() {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберие из какой акции необходимо удалить комикс\n1. Новый год\n2. Мужской день\n3. Женский день");
        int choice1;
        do {
            while (!in.hasNextInt()) {
                System.out.println("Выберие из какой акции необходимо удалить комикс\n1. Новый год\n2. Мужской день\n3. Женский день");
                in.next();
            }
            choice1 = in.nextInt();
        } while (choice1 <= -1);



        switch (choice1) {
            case 1: {
                if (DiscountNewYear.deleteNewYear()) {
                    System.out.println("Комикс удален из акции");
                } else {
                    System.out.println("Нет такого комикса в этой акции");
                }
                break;
            }
            case 2: {
                if (DiscountManDay.deleteManDay()) {
                    System.out.println("Комикс удален из акции");
                } else {
                    System.out.println("Нет такого комикса в этой акции");
                }
                break;
            }
            case 3: {
                if (DiscountWomanDay.deleteWomanDay()) {
                    System.out.println("Комикс удален из акции");
                } else {
                    System.out.println("Нет такого комикса в этой акции");
                }
                break;
            }
            default: {
                System.out.println("Такой акции нет. ");
                break;
            }
        }
    }


    public void addAction(ComicBase comicBase) {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n2. Мужской день\n3. Женский день");
        int choice1;
        do {
            while (!in.hasNextInt()) {
                System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n2. Мужской день\n3. Женский день");
                in.next();
            }
            choice1 = in.nextInt();
        } while (choice1 <= 0);

        System.out.println("Какой комикс нужно добавить к акции, введите id");
        int id = 0;
        do {
            try {
                id = in.nextInt();
                if (!comicBase.getComicDB().containsKey(id)) {
                    System.out.println("Такого id нет\nВведите корректный id");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Такого id нет\nВведите корректный id ");
                continue;
            }
        } while (id <= 0);

        switch (choice1) {
            case 1: {
                DiscountNewYear.addNewYear(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 2: {
                DiscountManDay.addManDay(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 3: {
                DiscountWomanDay.addWomanDay(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            default: {
                System.out.println("Такой акции нет. ");
                addAction(comicBase);
            }
        }
    }
}
