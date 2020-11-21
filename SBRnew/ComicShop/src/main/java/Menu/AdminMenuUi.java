package Menu;

import Bases.ComicBase;
import Bases.UsersDB;
import Discount.Discount;
import Serrialization.Serialization;
import Start.StartProgram;

import java.util.*;

public class AdminMenuUi {
    public void printAdminMenu(String login, ComicBase comicBase, Discount discount, UsersDB usersDB) {
        Serialization serialization = new Serialization();
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
        System.out.println("13. Доп. элементы меню");
        System.out.println("0. Закончить работу с приложением");

        boolean isInt = in.hasNextInt();

        if (isInt) {
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    comicBase.addComic();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 2: {
                    comicBase.deleteComic();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 3: {
                    comicBase.changeComic();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 4: {
                    comicBase.printComicDB();
                    comicBase.sellComic();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 5: {
                    comicBase.writeOffComic();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 6: {
                    comicBase.printComicDB();
                    discount.addAction(comicBase);
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 7: {
                    discount.printDiscount();
                    discount.deleteAction(comicBase);
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 8: {
                    discount.printDiscount();
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 9: {
                    System.out.println("В разработке");
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 10: {
                    System.out.println(serialization.deSerialization("ComicDB.txt"));
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 11: {
                    System.out.println(usersDB.changeRole(login));
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 12: {
                    System.out.println(usersDB.deleteUser());
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 13: {
                    UserMenuUi userMenuUi = new UserMenuUi();
                    userMenuUi.printUserMenu(login, comicBase, discount);
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
                case 0: {
                    StartProgram startProgram = new StartProgram();
                    startProgram.init();
                }
                default: {
                    System.out.println("Выберите один из доступных вариантов");
                    printAdminMenu(login, comicBase, discount, usersDB);
                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printAdminMenu(login, comicBase, discount, usersDB);
        }
    }
}
