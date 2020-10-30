
import java.util.Scanner;

public class UserMenu {

    static void printUserMenu(String login, ComicBase comicBase) {
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
                    System.out.println("Комиксы в базе");
                    comicBase.printComicDB();
                    printUserMenu(login, comicBase);
                    break;
                }
                case 2: {
                    comicBase.printComicDB();
                    System.out.println("Какой комикс продаём, введите id ");
                    int id = in.nextInt();
                    if(comicBase.getComicDB().get(id).getNumberOfComic() > 0) {
                        comicBase.getComicDB().get(id).setNumberOfComic(comicBase.getComicDB().get(id).getNumberOfComic() - 1);
                    } else {
                        System.out.println("Данный комикс закончился");
                        printUserMenu(login, comicBase);
                    }
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
                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printUserMenu(login, comicBase);
        }


    }
}
