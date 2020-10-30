import java.util.*;

public class Discount {

    List<Comic> newYear = new ArrayList<>();
    List<Comic> manDay = new ArrayList<>();
    List<Comic> womanDay = new ArrayList<>();

    void addNewYear(int id, ComicBase comicBase){
       newYear.add(comicBase.getComicDB().get(id));
    }

    void addManDay(int id, ComicBase comicBase){
        manDay.add(comicBase.getComicDB().get(id));
    }

    void addWomanDay(int id, ComicBase comicBase){
        womanDay.add(comicBase.getComicDB().get(id));
    }

    void printDiscount(){
        System.out.println("Акция нового года: ");
        newYear.forEach(System.out::println);
        System.out.println("Акция Мужского дня: ");
        manDay.forEach(System.out::println);
        System.out.println("Акция Женского дня: ");
        womanDay.forEach(System.out::println);
        System.out.println();
    }

    void addAction(ComicBase comicBase){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n 2. Мужской день\n3. Женский день");
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
                if (!comicBase.getComicDB().containsKey(id)){
                    System.out.println("Такого id нет\nВведите корректный id");
                    continue;
                }
            } catch (Exception e){
                System.out.println("Такого id нет\nВведите корректный id ");
                continue;
            }
        } while (id <= 0);

        switch (choice1) {
            case 1: {
                addNewYear(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 2: {
                addManDay(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
            case 3: {
                addWomanDay(id, comicBase);
                System.out.println("Комикс добавлен к акции");
                break;
            }
        }
    }


}
