import java.util.Scanner;

public class StartProgram {

    static void start(){
        ComicBase comicBase = new ComicBase();
        Discount discount = new Discount();
        UsersDB usersDB = new UsersDB();
        usersDB.userFactory();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = in.next();
        System.out.print("Введите пароль: ");
        String password = in.next();

//        System.out.println(usersDB.getUserDB().containsKey(login));

//        try {
//            boolean b = usersDB.getUserDB().values().;
//            System.out.println(b);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

//        if(usersDB.getUserDB().containsKey(login)){
//            System.out.println("Enter");
//        } else {
//            System.out.println("Note Enter");
//        }


//        if(login.equals(login)){
//
//            comicBase.comicFactory();
//            AdminMenu.printAdminMenu(login, comicBase, discount);
//        }

    }

}
