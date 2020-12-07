package menu;

import bases.ComicBase;

import java.util.Scanner;
import serrialization.Serialization;
import start.StartProgram;
import popularComic.PopularityComic;
import discount.DiscountBase;

public class UserMenuUi {
    Scanner in = new Scanner(System.in);

    public void printUserMenu(String login, ComicBase comicBase, DiscountBase discountBase, PopularityComic popularityComic) {
        while (true) {
            System.out.println("Добро пожаловать: " + login);
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1. Показать список комиксов");
            System.out.println("2. Купить комикс");
            System.out.println("3. Зарезирвировать комикс");
            System.out.println("4. Список новинок");
            System.out.println("5. Список самых продаваемых комиксов");
            System.out.println("6. Список самых популярных авторов");
            System.out.println("7. Список самых популярных комиксов за день");
            System.out.println("8. Список самых популярных комиксов за месяц");
            System.out.println("9. Список самых популярных комиксов за год");
            System.out.println("10. Показать акционные комиксы");
            System.out.println("0. Закончит работу с приложением");

            boolean isInt = in.hasNextInt();

            if (isInt) {
                int choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Комиксы в базе");
                        for (Integer key : comicBase.getComicDB().keySet()) {
                            System.out.println("Id " + key + " {" + comicBase.getComicDB().get(key).getNameComic() + '\'' +
                                    ", имя автора -'" + comicBase.getComicDB().get(key).getNameAuthor() + '\'' +
                                    ", страницы - " + comicBase.getComicDB().get(key).getNumberOfPages() +
                                    ", жанр -'" + comicBase.getComicDB().get(key).getGenre() + '\'' +
                                    ", год выпуска - " + comicBase.getComicDB().get(key).getYearOfPublishing() +
                                    ", цена продажи - " + comicBase.getComicDB().get(key).getPriceForSale() +
                                    ", вселенная - " + comicBase.getComicDB().get(key).getComicSeries() + '\'' +
                                    ", количество экземпляров - " + comicBase.getComicDB().get(key).getNumberOfComic() +
                                    '}');
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Комиксы в базе");
                        System.out.println(new Serialization().deSerialization("ComicDB.txt"));
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
                    case 3: {
                        System.out.println("В разработке");
                        break;
                    }
                    case 4: {
                        System.out.println("---------------------------------------");
                        System.out.println("Новинки!!!");
                        System.out.println("---------------------------------------");
                        comicBase.newComic().forEach(System.out::println);
                        break;
                    }
                    case 5: {
                        System.out.println("---------------------------------");
                        System.out.println("Список самых продаваемых комиксов");
                        System.out.println("---------------------------------");
                        popularityComic.printBestOfTheBest(20).forEach(x -> System.out.println(x.getKey()));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 6: {
                        System.out.println("-------------------------------");
                        System.out.println("Список самых популярных авторов");
                        System.out.println("-------------------------------");
                        popularityComic.printBestAuthor().forEach((k, v) -> System.out.println(k));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 7: {
                        System.out.println("----------------------------------------");
                        System.out.println("Список самых популярных комиксов за день");
                        System.out.println("----------------------------------------");
                        popularityComic.printBestOfDay().forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 8: {
                        System.out.println("-----------------------------------------");
                        System.out.println("Список самых популярных комиксов за месяц");
                        System.out.println("-----------------------------------------");
                        popularityComic.printBestOfMonth(3).forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 9: {
                        System.out.println("---------------------------------------");
                        System.out.println("Список самых популярных комиксов за год");
                        System.out.println("---------------------------------------");
                        popularityComic.printBestOfYear(12).forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 10: {
                        printDiscount(discountBase);
                        break;
                    }
                    case 0: {
                        new StartProgram().init();
                    }
                }
            } else {
                System.out.println("Выберите один из предложенных вариантов\n");
            }
            printUserMenu(login, comicBase, discountBase, popularityComic);
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
