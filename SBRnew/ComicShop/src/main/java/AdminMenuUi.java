import java.util.*;

public class AdminMenuUi {

    static void printAdminMenu(String login, ComicBase comicBase, Discount discount) {
        Scanner in = new Scanner(System.in);

        System.out.println("Добро пожаловать: " + login);
        System.out.println("Выберите что необходимо сделать: ");
        System.out.println("1. Добавить комикс");
        System.out.println("2. Удалить комикс");
        System.out.println("3. Изменить коммикс");
        System.out.println("4. Продать комикс");
        System.out.println("5. Списать комикс");
        System.out.println("6. Добавить комикс к акции");
        System.out.println("7. Показать акционные комиксы");
        System.out.println("8. Отложить комикс определенному покупателю");
        System.out.println("9. Показать комиксы в наличии");
        System.out.println("10. Изменить права у пользователя");
        System.out.println("11. Удалить пользователя");
        System.out.println("0. Выход");

        boolean isInt = in.hasNextInt();

        if (isInt) {
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    comicBase.addComic();
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 2: {
                    comicBase.deleteComic();
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 3: {
                    comicBase.changeComic();
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 4: {
                    comicBase.printComicDB();
                    System.out.println("Какой комикс продаём, введите id ");
                    int id = in.nextInt();
                    if (comicBase.getComicDB().get(id).getNumberOfComic() > 0) {
                        comicBase.getComicDB().get(id).setNumberOfComic(comicBase.getComicDB().get(id).getNumberOfComic() - 1);
                    } else {
                        System.out.println("Данный комикс закончился");
                    }
                    Serialization.serializationObject(comicBase.getComicDB(), "ComicDB.txt");
                    printAdminMenu(login, comicBase, discount);
                }
                case 5: {
                    comicBase.printComicDB();
                    System.out.println("Какой комикс списываем, введите id ");
                    int id = in.nextInt();
                    if (comicBase.getComicDB().get(id).getNumberOfComic() > 0) {
                        comicBase.getComicDB().get(id).setNumberOfComic(comicBase.getComicDB().get(id).getNumberOfComic() - 1);
                    } else {
                        System.out.println("Данный комикс закончился");
                    }
                    Serialization.serializationObject(comicBase.getComicDB(), "ComicDB.txt");
                    printAdminMenu(login, comicBase, discount);
                }
                case 6: {
                    comicBase.printComicDB();
                    discount.addAction(comicBase);
                    printAdminMenu(login, comicBase, discount);
                }
                case 7: {
                    System.out.println("Доступные акции: ");
                    discount.printDiscount();
                    printAdminMenu(login, comicBase, discount);
                }
                case 8: {

                }
                case 9: {
                    System.out.println("Комиксы в базе");
                    System.out.println(DeSerialization.deSerialization("ComicDB.txt"));
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 10 : {
                    System.out.println(UsersDB.changeRole(login));
                    printAdminMenu(login, comicBase, discount);
                }
                case 11 : {
                    System.out.println(UsersDB.deleteUser());
                    printAdminMenu(login, comicBase, discount);
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Выберите один из доступных вариантов");
                    printAdminMenu(login, comicBase, discount);
                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printAdminMenu(login, comicBase, discount);
        }
    }
}
