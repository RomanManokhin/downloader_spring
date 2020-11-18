
import java.util.Scanner;

public class UserMenuUi {

    static void printUserMenu(String login, ComicBase comicBase, Discount discount) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать: " + login);
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1. Показать список комиксов");
        System.out.println("2. Купить комикс");
        System.out.println("3. Зарезирвировать комикс");
        System.out.println("4. Список новинок");
        System.out.println("5. Список самых продаваемых комиксов");
        System.out.println("6. Список самых популярных авторов");
        System.out.println("7. Список самых популярных жанров за день");
        System.out.println("8. Список самых популярных жанров за месяц");
        System.out.println("9. Список самых популярных жанров за год");
        System.out.println("0. Закончит работу с приложением");

        boolean isInt = in.hasNextInt();

        if (isInt) {
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    comicBase.printComicDB();
                    printUserMenu(login, comicBase, discount);
                }
                case 2: {
                    comicBase.sellComic();
                    printUserMenu(login, comicBase, discount);
                }
                case 3: {

                }
                case 4: {

                }
                case 5: {

                }
                case 6: {

                }
                case 7: {

                }
                case 8: {

                }
                case 9: {

                }
                case 0: {
                    StartProgram.init();
                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printUserMenu(login, comicBase, discount);
        }


    }
}
