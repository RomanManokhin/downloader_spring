import java.util.Scanner;

public class StartProgram {

    static void init() {
        Scanner in = new Scanner(System.in);
        ComicBase comicBase = new ComicBase();
        comicBase.comicFactory();
        Discount discount = new Discount();

        while (true) {
            System.out.println("Добро пожаловать!");
            System.out.print("Введите логин: ");
            String login = in.next();
            String role = UsersDB.start(login);
            if(role.equals("wrong")){
                continue;
            } else{
                if(role.equals("admin")){
                    AdminMenu.printAdminMenu(login, comicBase, discount);
                } else {
                    UserMenu.printUserMenu(login, comicBase);
                }
            }
            break;
        }
    }


}
