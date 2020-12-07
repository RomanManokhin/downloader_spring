package menu;

import bases.ComicBase;
import bases.UsersDB;
import serrialization.Serialization;
import start.StartProgram;
import popularComic.PopularityComic;
import discount.DiscountBase;

import java.time.LocalDate;
import java.util.*;

public class AdminMenuUi {
    Scanner in = new Scanner(System.in);
    Serialization serialization = new Serialization();


    public void printAdminMenu(String login, ComicBase comicBase, DiscountBase discountBase, UsersDB usersDB, PopularityComic popularityComic) {
        while (true) {
            System.out.println("Добро пожаловать: " + login);
            System.out.println("Выберите что необходимо сделать: ");
            System.out.println("1. Добавить комикс");
            System.out.println("2. Удалить комикс");
            System.out.println("3. Изменить коммикс");
            System.out.println("4. Продать комикс");
            System.out.println("5. Списать комикс");
            System.out.println("6. Добавить комикс к акции");
            System.out.println("7. Удалить коммикс из акции");
            System.out.println("8. Показать акционные комиксы");
            System.out.println("9. Отложить комикс определенному покупателю");
            System.out.println("10. Показать комиксы в наличии");
            System.out.println("11. Изменить права у пользователя");
            System.out.println("12. Удалить пользователя");
            System.out.println("13. Список новинок");
            System.out.println("14. Список самых продаваемых комиксов");
            System.out.println("15. Список самых популярных авторов");
            System.out.println("16. Список самых популярных комиксов за день");
            System.out.println("17. Список самых популярных комиксов за месяц");
            System.out.println("18. Список самых популярных комиксов за год");
            System.out.println("0. Закончить работу с приложением");

            if (in.hasNextInt()) {
                int choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        in.nextLine();
                        System.out.println("Введите название комикса: ");
                        String nameComic = in.nextLine();

                        System.out.println("Введите имя автора: ");
                        String nameAuthor = in.nextLine();

                        int numberOfPages;
                        do {
                            System.out.println("Введите количество страниц: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите количество страниц: ");
                                in.next();
                            }
                            numberOfPages = in.nextInt();
                        } while (numberOfPages <= 0);

                        System.out.println("Введите жанр комикса: ");
                        String genre = in.next();


                        Integer year = null;
                        Integer month = null;
                        Integer day = null;
                        boolean b = true;
                        while (b) {
                            System.out.println("Введите год публикации комикса, в формате YYYY-MM-DD: ");
                            String yearOfPublishing = in.next();
                            String[] arrString = yearOfPublishing.split("-");
                            if (yearOfPublishing.matches("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])")) {
                                for (int i = 0; i < 3; i++) {
                                    year = Integer.parseInt(arrString[0]);
                                    month = Integer.parseInt(arrString[1]);
                                    day = Integer.parseInt(arrString[2]);
                                }
                                b = false;
                            }
                        }

                        int costPrice;
                        do {
                            System.out.println("Введите цену закупки: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите цену закупки: ");
                                in.next();
                            }
                            costPrice = in.nextInt();
                        } while (costPrice <= 0);

                        int priceForSale;
                        do {
                            System.out.println("Введите цену продажи: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите цену продажи: ");
                                in.next();
                            }
                            priceForSale = in.nextInt();
                        } while (priceForSale <= 0);

                        in.nextLine();
                        System.out.println("Введите название серии комиксов");
                        String comicSeries = in.nextLine();

                        int numberOfComic;
                        do {
                            System.out.println("Введите количество экземпляров комикса: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите количество экземпляров комикса: ");
                                in.next();
                            }
                            numberOfComic = in.nextInt();
                        } while (numberOfComic <= 0);
                        System.out.println("new id = " + (comicBase.getComicDB().lastKey() + 1));
                        comicBase.addComic(nameComic, nameAuthor, numberOfPages, genre, LocalDate.of(year, month, day), costPrice, priceForSale, comicSeries, numberOfComic);
                        System.out.println("Комикс " + nameComic + " добавлен");
                        break;
                    }
                    case 2: {
                        System.out.println("Комиксы в базе");
                        System.out.println(serialization.deSerialization("ComicDB.txt"));
                        int id;
                        while (true) {
                            System.out.println("Какой комикс необходимо удалить");
                            String s = in.next();
                            try {
                                id = Integer.parseInt(s);
                            } catch (NumberFormatException ex) {
                                System.out.println("Введено не число");
                                continue;
                            }
                            if (comicBase.getComicDB().containsKey(id)) {
                                comicBase.deleteComic(id);
                                System.out.println("Комикс удален");
                                break;
                            } else {
                                System.out.println("Такого id нет");
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Комиксы в базе");
                        System.out.println(serialization.deSerialization("ComicDB.txt"));
                        int id = 0;
                        do {
                            System.out.print("Введите id для изменения: ");
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
                            System.out.println("Выберите, что необходимо изменить ");
                            System.out.println("1. Название комикса");
                            System.out.println("2. Имя автора");
                            System.out.println("3. Количество страниц");
                            System.out.println("4. Жанр");
                            System.out.println("5. Год публикации");
                            System.out.println("6. Цена закупки");
                            System.out.println("7. Цена продажи");
                            System.out.println("8. Вселенная");
                            System.out.println("9. Количество комиксов в наличии");
                            System.out.println("0. Выйти из редактирования");
                            boolean isInt1 = in.hasNextInt();
                            if (isInt1) {
                                int choice1 = in.nextInt();
                                switch (choice1) {
                                    case 1: {
                                        in.nextLine();
                                        System.out.println("Введите новое название комикса: ");
                                        String nameComic = in.nextLine();
                                        comicBase.getComicDB().get(id).setNameComic(nameComic);
                                        System.out.println("Название изменено на : " + nameComic);
                                        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        break;
                                    }
                                    case 2: {
                                        in.nextLine();
                                        System.out.println("Введите имя автора: ");
                                        String nameAuthor = in.nextLine();
                                        comicBase.getComicDB().get(id).setNameAuthor(nameAuthor);
                                        System.out.println("Название изменено на : " + nameAuthor);
                                        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        break;
                                    }
                                    case 3: {
                                        int numberOfPages;
                                        do {
                                            System.out.println("Введите количество страниц: ");
                                            while (!in.hasNextInt()) {
                                                System.out.println("Введите количество страниц: ");
                                                in.next();
                                            }
                                            numberOfPages = in.nextInt();
                                            comicBase.getComicDB().get(id).setNumberOfPages(numberOfPages);
                                            serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        } while (numberOfPages <= 0);
                                        System.out.println("Количество страниц изменено на : " + numberOfPages);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Введите жанр комикса: ");
                                        String genre = in.next();
                                        comicBase.getComicDB().get(id).setGenre(genre);
                                        System.out.println("Жанр изменён на : " + genre);
                                        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        break;
                                    }
                                    case 5: {
//                                        int yearOfPublishing;
//                                        do {
//                                            System.out.println("Введите год публикации комикса: ");
//                                            while (!in.hasNextInt()) {
//                                                System.out.println("Введите год публикации комикса: ");
//                                                in.next();
//                                            }
//                                            yearOfPublishing = in.nextInt();
//                                            comicBase.getComicDB().get(id).setYearOfPublishing(yearOfPublishing);
//                                            serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
//                                        } while (yearOfPublishing <= 0);
//                                        System.out.println("Год публикации изменён на : " + yearOfPublishing);

                                        Integer year = null;
                                        Integer month = null;
                                        Integer day = null;
                                        boolean b = true;
                                        while (b) {
                                            System.out.println("Введите год публикации комикса, в формате YYYY-MM-DD: ");
                                            String yearOfPublishing = in.next();
                                            String[] arrString = yearOfPublishing.split("-");
                                            if (yearOfPublishing.matches("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])")) {
                                                for (int i = 0; i < 3; i++) {
                                                    year = Integer.parseInt(arrString[0]);
                                                    month = Integer.parseInt(arrString[1]);
                                                    day = Integer.parseInt(arrString[2]);
                                                }
                                                b = false;
                                            }
                                        }
                                        comicBase.getComicDB().get(id).setYearOfPublishing(LocalDate.of(year, month, day));
                                        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        break;
                                    }
                                    case 6: {
                                        int costPrice;
                                        do {
                                            System.out.println("Введите цену закупки: ");
                                            while (!in.hasNextInt()) {
                                                System.out.println("Введите цену закупки: ");
                                                in.next();
                                            }
                                            costPrice = in.nextInt();
                                            comicBase.getComicDB().get(id).setCostPrice(costPrice);
                                            serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        } while (costPrice <= 0);
                                        System.out.println("Цена закупки изменан на : " + costPrice);
                                        break;
                                    }
                                    case 7: {
                                        double priceForSale;
                                        do {
                                            System.out.println("Введите цену продажи: ");
                                            while (!in.hasNextDouble()) {
                                                System.out.println("Введите цену продажи: ");
                                                in.next();
                                            }
                                            priceForSale = in.nextDouble();
                                            comicBase.getComicDB().get(id).setPriceForSale(priceForSale);
                                            serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        } while (priceForSale <= 0);
                                        System.out.println("Цена продажи изменана на : " + priceForSale);
                                        break;
                                    }
                                    case 8: {
                                        System.out.println("Введите название серии комиксов");
                                        String comicSeries = in.nextLine();
                                        comicBase.getComicDB().get(id).setComicSeries(comicSeries);
                                        System.out.println("Название серии изменено на : " + comicSeries);
                                        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        break;
                                    }
                                    case 9: {
                                        int numberOfComic;
                                        do {
                                            System.out.println("Введите количество экземпляров комикса: ");
                                            while (!in.hasNextInt()) {
                                                System.out.println("Введите количество экземпляров комикса: ");
                                                in.next();
                                            }
                                            numberOfComic = in.nextInt();
                                            comicBase.getComicDB().get(id).setNumberOfComic(numberOfComic);
                                            serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
                                        } while (numberOfComic <= 0);
                                        System.out.println("Количество экземпляров изменено на : " + numberOfComic);
                                        break;
                                    }
                                    case 0:
                                        break;
                                    default: {
                                        System.out.println("Такого пункта меню нет");
                                        continue;
                                    }
                                }
                            }
                        } while (id < 0);
                        break;
                    }
                    case 4: {
                        System.out.println("Комиксы в базе");
                        System.out.println(serialization.deSerialization("ComicDB.txt"));
                        int id;
                        do {
                            System.out.println("Введите id комикса ");
                            while (!in.hasNextInt()) {
                                System.out.print("Введите id комикса  ");
                                in.next();
                            }
                            id = in.nextInt();
                            if (comicBase.sellComic(id)) {
                                System.out.println("Комикс продан");
                            } else {
                                System.out.println("Нет такого комикса в наличии");
                            }

                        } while (id <= 0);
                        break;
                    }
                    case 5: {
                        System.out.println("Комиксы в базе");
                        System.out.println(serialization.deSerialization("ComicDB.txt"));
                        int id;
                        do {
                            System.out.println("Введите id комикса ");
                            while (!in.hasNextInt()) {
                                System.out.print("Введите id комикса  ");
                                in.next();
                            }
                            id = in.nextInt();
                            if (comicBase.sellComic(id)) {
                                System.out.println("Комикс списан");
                            } else {
                                System.out.println("Нет такого комикса в наличии");
                            }

                        } while (id <= 0);
                        break;
                    }
                    case 6: {
                        System.out.println("Комиксы в базе");
                        System.out.println(serialization.deSerialization("ComicDB.txt"));

                        int choiceDiscountName;
                        while (true) {
                            System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n2. 8 Марта\n3. 23 Февраля");
                            String s = in.next();
                            try {
                                choiceDiscountName = Integer.parseInt(s);
                                if (choiceDiscountName < 4 && choiceDiscountName > 0) break;
                            } catch (NumberFormatException ex) {
                                System.out.println("Введено не число");
                            }
                        }

                        int id;
                        while (true) {
                            System.out.println("Какой комикс нужно добавить к акции, введите id");
                            String s = in.next();
                            try {
                                id = Integer.parseInt(s);
                                if (!comicBase.getComicDB().containsKey(id) && comicBase.getComicDB().get(id) == null) {
                                    System.out.println("Такого id нет");
                                } else {
                                    if (discountBase.addDiscount(choiceDiscountName, id, comicBase)) {
                                        System.out.println("Комикс добавлен к акции");
                                        break;
                                    } else {
                                        System.out.println("Комикс участвует в акции");
                                    }
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Введено не число");
                            }
                        }
                        break;
                    }
                    case 7: {
                        printDiscount(discountBase);

                        int choiceDiscountName;
                        while (true) {
                            System.out.println("Выберие из какой акции необходимо удалить комикс\n1. Новый год\n2. 8 Марта\n3. 23 Февраля");
                            String s = in.next();
                            try {
                                choiceDiscountName = Integer.parseInt(s);
                                if (choiceDiscountName < 4 && choiceDiscountName > 0) break;
                            } catch (NumberFormatException ex) {
                                System.out.println("Введено не число");
                            }
                        }

                        int id;
                        while (true) {
                            System.out.println("Какой комикс нужно удалить из акции, введите id");
                            String s = in.next();
                            try {
                                id = Integer.parseInt(s);
                                if (!discountBase.deleteDiscount(choiceDiscountName, id)) {
                                    System.out.println("Такого id нет");
                                } else {
                                    System.out.println("Комикс удалён из акции");
                                    break;
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Введено не число");
                            }
                        }
                        break;
                    }
                    case 8: {
                        printDiscount(discountBase);
                        break;
                    }
                    case 9: {
                        System.out.println("---------------------------------------");
                        System.out.println("Новинки!!!");
                        System.out.println("---------------------------------------");
                        comicBase.newComic().forEach(System.out::println);
                        break;
                    }
                    case 10: {
                        comicBase.getComicDB().forEach((k, v) -> System.out.println(k + ": " + v));
                        break;
                    }
                    case 11: {
                        System.out.println("Какому пользователю необходимо изменить права?\nИли 0 для отмены");
                        usersDB.getUserDB().forEach((k, v) -> System.out.println(k + ": " + v));
                        String changedName = in.next();
                        if (changedName.equals("0")) {
                            break;
                        } else {
                            if (!usersDB.changeRole(changedName, login)) {
                                System.out.println("Нет такого пользователя");
                            } else {
                                System.out.println("Права изменены");
                            }
                        }
                        break;
                    }
                    case 12: {
                        System.out.println("Какого пользователя необходимо удалить\nИли 0 для отмены");
                        usersDB.getUserDB().forEach((k, v) -> System.out.println(k + ": " + v));
                        String deleteName = in.next();
                        if (deleteName.equals("0")) {
                            break;
                        } else if (deleteName.equals(login)) {
                            System.out.println("Нельзя удалить себя =)");
                            break;
                        }
                        if (!usersDB.deleteUser(deleteName, login)) {
                            System.out.println("Нет такого пользователя");
                        } else {
                            System.out.println("Пользователь удален");
                        }
                        break;
                    }
                    case 13: {
                        System.out.println(" В разработке ╮(￣_￣)╭");
                        break;
                    }
                    case 14: {
                        System.out.println("---------------------------------");
                        System.out.println("Список самых продаваемых комиксов");
                        System.out.println("---------------------------------");
                        popularityComic.printBestOfTheBest(20).forEach(x -> System.out.println(x.getKey()));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 15: {
                        System.out.println("-------------------------------");
                        System.out.println("Список самых популярных авторов");
                        System.out.println("-------------------------------");
                        popularityComic.printBestAuthor().forEach((k, v) -> System.out.println(k));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 16: {
                        System.out.println("----------------------------------------");
                        System.out.println("Список самых популярных комиксов за день");
                        System.out.println("----------------------------------------");
                        popularityComic.printBestOfDay().forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 17: {
                        System.out.println("-----------------------------------------");
                        System.out.println("Список самых популярных комиксов за месяц");
                        System.out.println("-----------------------------------------");
                        popularityComic.printBestOfMonth(3).forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 18: {
                        System.out.println("---------------------------------------");
                        System.out.println("Список самых популярных комиксов за год");
                        System.out.println("---------------------------------------");
                        popularityComic.printBestOfYear(12).forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 0: {
                        new StartProgram().init();
                    }
                    default: {
                        System.out.println("Выберите один из доступных вариантов");
                        break;
                    }
                }
            } else {
                System.out.println("Выберите один из предложенных вариантов\n");
            }
        }
    }

    void printDiscount(DiscountBase discountBase) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Акции: ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Новый год:");
        System.out.println("------------------------------------------------------------------------------------");
        discountBase.printDiscountNewYear().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("8 Марта:");
        System.out.println("------------------------------------------------------------------------------------");
        discountBase.printDiscountWomenDay().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("23 Февраля:");
        System.out.println("------------------------------------------------------------------------------------");
        discountBase.printDiscountManDay().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
    }

}
