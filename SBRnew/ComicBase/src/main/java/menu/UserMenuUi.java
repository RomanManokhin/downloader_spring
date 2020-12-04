package menu;

import bases.ComicBase;

import java.util.Scanner;


import start.StartProgram;
import popularComic.PopularityComic;
import discount.DiscountBase;

public class UserMenuUi {



    public void printUserMenu(String login, ComicBase comicBase, DiscountBase discountBase, PopularityComic popularityComic) {
        Scanner in = new Scanner(System.in);
        StartProgram st = new StartProgram();

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
                    comicBase.printComicDBForUser();
                    printUserMenu(login, comicBase, discountBase, popularityComic);
                }
                case 2: {
//                    comicBase.sellComic();
                    printUserMenu(login, comicBase, discountBase, popularityComic);
                }
                case 3: {
                    System.out.println("В разработке");
                    printUserMenu(login, comicBase, discountBase, popularityComic);
                }
                case 4: {
                    System.out.println("В разработке");
                    printUserMenu(login, comicBase, discountBase, popularityComic);
                }
                case 5: {
//                    popularityComic.printBestOfTheBest();
                    st.init();
                }
//                case 6: {
//                    popularityComic.printBestAuthor();
//                    st.init();
//                }
//                case 7: {
//                    popularityComic.printBestOfDay();
//                    st.init();
//                }
//                case 8: {
//                    popularityComic.printBestOfMonth();
//                    st.init();
//                }
//                case 9: {
//                    popularityComic.printBestOfYear();
//                    st.init();
//                }
//                case 10: {
//                    new AdminMenuUi().printDiscount(discountBase);
//                    st.init();
//                }
//                case 0: {
//                    st.init();
//                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printUserMenu(login, comicBase, discountBase, popularityComic);
        }


    }
    void printDiscount(DiscountBase discountBase){
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
