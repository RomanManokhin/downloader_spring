package Menu;

import Bases.Comic;
import Bases.ComicBase;
import Bases.UsersDB;
import Serrialization.Serialization;
import Start.StartProgram;
import popularComic.PopularityComic;
import discount.DiscountBase;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class AdminMenuUi {

    public void printAdminMenu(String login, ComicBase comicBase, DiscountBase discountBase, UsersDB usersDB, PopularityComic popularityComic) {
        while (true) {
            Scanner in = new Scanner(System.in);
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
                        comicBase.addComic();
                        break;
                    }
                    case 2: {
                        comicBase.deleteComic();
                        break;
                    }
                    case 3: {
                        comicBase.changeComic();
                        break;
                    }
                    case 4: {
                        comicBase.printComicDB();
                        comicBase.sellComic();
                        break;
                    }
                    case 5: {
                        comicBase.writeOffComic();
                        break;
                    }
                    case 6: {
                        comicBase.printComicDB();

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
                        System.out.println("В разработке ╮(￣_￣)╭");
                        break;
                    }
                    case 10: {
                        comicBase.getComicDB().forEach((k, v) -> System.out.println(k + ": " + v));
                        break;
                    }
                    case 11: {
                        System.out.println(usersDB.changeRole(login));
                        break;
                    }
                    case 12: {
                        System.out.println(usersDB.deleteUser());
                        break;
                    }
                    case 13: {

                    }
                    case 14: {
                        System.out.println("---------------------------------");
                        System.out.println("Список самых продаваемых комиксов");
                        System.out.println("---------------------------------");
                        Stream<Map.Entry<Comic, ArrayList<LocalDate>>> info = popularityComic.printBestOfTheBest(20);
                        info.forEach(x -> System.out.println(x.getKey()));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 15: {
                        System.out.println("-------------------------------");
                        System.out.println("Список самых популярных авторов");
                        System.out.println("-------------------------------");
                        HashMap<String, Integer> info = popularityComic.printBestAuthor();
                        info.forEach((k,v) -> System.out.println(k));
                        System.out.println("-------------------------------");
                        break;
                    }
                    case 16: {
                        System.out.println("----------------------------------------");
                        System.out.println("Список самых популярных комиксов за день");
                        System.out.println("----------------------------------------");
                        Stream<Map.Entry<Comic, List<LocalDate>>> info = popularityComic.printBestOfDay();
                        info.forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 17: {
//                        popularityComic.printBestOfMonth();
                        System.out.println("-----------------------------------------");
                        System.out.println("Список самых популярных комиксов за месяц");
                        System.out.println("-----------------------------------------");
                        Stream<Map.Entry<Comic, List<LocalDate>>> info = popularityComic.printBestOfMonth(3);
                        info.forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 18: {
                        System.out.println("---------------------------------------");
                        System.out.println("Список самых популярных комиксов за год");
                        System.out.println("---------------------------------------");
                        Stream<Map.Entry<Comic, List<LocalDate>>> info = popularityComic.printBestOfYear(12);
                        info.forEach(x -> System.out.println(x.getKey()));
                        break;
                    }
                    case 0: {
                        StartProgram startProgram = new StartProgram();
                        startProgram.init();
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


    public void printDiscount(DiscountBase discountBase) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Акции: ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Новый год:");
        System.out.println("------------------------------------------------------------------------------------");

//        System.out.println(serialization.deSerialization("DiscountNewYear.txt"));
        discountBase.getNewYear().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("8 Марта:");
        System.out.println("------------------------------------------------------------------------------------");

//        System.out.println(serialization.deSerialization("DiscountWomenDay.txt"));
        discountBase.getWomenDay().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("23 Февраля:");
        System.out.println("------------------------------------------------------------------------------------");

//        System.out.println(serialization.deSerialization("DiscountManDay.txt"));
        discountBase.getManDay().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------------------------------------------------------");
    }
}
