package Start;

import Bases.ComicBase;
import Bases.UsersDB;
import Discount.Discount;
import Menu.AdminMenuUi;
import Menu.UserMenuUi;
import Discount.PopularityComic;

import java.util.Scanner;

public class StartProgram {
    public static void main(String[] args) {
        StartProgram startProgram = new StartProgram();
        startProgram.init();
    }

    public  void init() {
        Scanner in = new Scanner(System.in);
        ComicBase comicBase = new ComicBase();
        Discount discount = new Discount();
        comicBase.loadDb("ComicDB.txt");
        PopularityComic popularityComic = new PopularityComic();
        popularityComic.initPopularity(comicBase);
        UsersDB usersDB = new UsersDB();
        usersDB.userDBInit();

        while (true) {
            System.out.println("Добро пожаловать!");
            System.out.print("Введите логин: ");
            String login = in.next();
            String role = usersDB.start(login);
            if (role.equals("wrong")) {
                continue;
            } else {
                if (role.equals("admin")) {
                    AdminMenuUi adminMenuUi = new AdminMenuUi();
                    adminMenuUi.printAdminMenu(login, comicBase, discount, usersDB, popularityComic);
                } else {
                    UserMenuUi userMenuUi = new UserMenuUi();
                    userMenuUi.printUserMenu(login, comicBase, discount, popularityComic);
                }
            }
            break;
        }
    }


}
