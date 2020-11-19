import java.util.Scanner;

public class StartProgram {
    public static void main(String[] args) {
        StartProgram.init();
    }

    static void init() {
        Scanner in = new Scanner(System.in);
        ComicBase comicBase = new ComicBase();
        Discount discount = new Discount();
        comicBase.loadDb("ComicDB.txt");
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
                    AdminMenuUi.printAdminMenu(login, comicBase, discount, usersDB);
                } else {
                    UserMenuUi.printUserMenu(login, comicBase, discount);
                }
            }
            break;
        }
    }


}
