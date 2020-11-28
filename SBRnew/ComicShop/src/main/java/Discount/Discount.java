package Discount;

import Bases.ComicBase;

import java.util.*;

public class Discount {
    DiscountNewYear discountNewYear = new DiscountNewYear();
    DiscountManDay discountManDay = new DiscountManDay();
    DiscountWomanDay discountWomanDay = new DiscountWomanDay();


    public Discount() {
        discountNewYear.InitDiscountNewYear();
        discountManDay.InitDiscountManDay();
        discountWomanDay.InitDiscountWomanDay();
    }

    public void printDiscount() {
        System.out.println("Доступные акции: ");
        discountNewYear.printNewYear();
        discountManDay.printManDay();
        discountWomanDay.printWomanDay();
    }

    public void deleteAction(ComicBase comicBase) {
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
                if (discountNewYear.deleteNewYear(comicBase)) {
                    System.out.println("Комикс удален из акции");
                } else {
                    System.out.println("Нет такого комикса в этой акции");
                }
                break;
            }
            case 2: {
                if (discountManDay.deleteManDay(comicBase)) {
                    System.out.println("Комикс удален из акции");
                } else {
                    System.out.println("Нет такого комикса в этой акции");
                }
                break;
            }
            case 3: {
                if (discountWomanDay.deleteWomanDay(comicBase)) {
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
                if (!comicBase.getComicDB().containsKey(id) && comicBase.getComicDB().get(id) == null) {
                    System.out.println("Такого id нет\nВведите корректный id");
                    addAction(comicBase);
                }
            } catch (Exception e) {
                System.out.println("Такого id нет\nВведите корректный id ");
                addAction(comicBase);
            }
        } while (id <= 0);

        switch (choice1) {
            case 1: {
                discountNewYear.addNewYear(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 2: {
                discountManDay.addManDay(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 3: {
                discountWomanDay.addWomanDay(id, comicBase);
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
