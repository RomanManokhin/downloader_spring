import java.util.Scanner;

public class StartProgram {



    static void start(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = in.next();
        System.out.println("Введите пароль: ");
        String password = in.next();

        if(login.equals(login)){
            ComicBase comicBase = new ComicBase();
            Discount discount = new Discount();
            comicBase.comicFactory();
            AdminMenu.printAdminMenu(login, comicBase, discount);
        }

    }

}
