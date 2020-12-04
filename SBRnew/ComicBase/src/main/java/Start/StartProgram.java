package Start;

import Bases.ComicBase;
import Bases.UsersDB;
import Menu.AdminMenuUi;
import Menu.UserMenuUi;
import popularComic.PopularityComic;
import discount.DiscountBase;

import java.util.Scanner;

public class StartProgram {
    public static void main(String[] args) {
                new StartProgram().init();
    }

    public  void init() {
        Scanner in = new Scanner(System.in);
        ComicBase comicBase = new ComicBase();
        DiscountBase discountBase = new DiscountBase();
        PopularityComic popularityComic = new PopularityComic();
        UsersDB usersDB = new UsersDB();

        comicBase.loadDb("ComicDB.txt");
        popularityComic.initPopularity(comicBase);
        usersDB.userDBInit();
        discountBase.init(comicBase);

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
                    adminMenuUi.printAdminMenu(login, comicBase, discountBase, usersDB, popularityComic);
                } else {
                    UserMenuUi userMenuUi = new UserMenuUi();
                    userMenuUi.printUserMenu(login, comicBase, discountBase, popularityComic);
                }
            }
        }
    }
}
