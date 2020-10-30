import java.util.Scanner;

public class StartProgram {

    static void init() {
        Scanner in = new Scanner(System.in);
        ComicBase comicBase = new ComicBase();

        Discount discount = new Discount();

//        Thread goSave = new Thread(() -> {
//                while (true){
//                    Serialization.serializationObject(comicBase.getComicDB(), "ComicDB.txt");
//                    Serialization.serializationObject(UsersDB.userDB, "loginData.txt");
//                    UsersDB.userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
//                    ComicBase.comicDB = (SortedMap<Integer, Comic>) DeSerialization.deSerialization("ComicDB.txt");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        });
//
//        goSave.start();

        while (true) {
            System.out.println("Добро пожаловать!");
            System.out.print("Введите логин: ");
            String login = in.next();
            String role = UsersDB.start(login);
            if(role.equals("wrong")){
                continue;
            } else{
                if(role.equals("admin")){
                    AdminMenuUi.printAdminMenu(login, comicBase, discount);
                } else {
                    UserMenuUi.printUserMenu(login, comicBase);
                }
            }
            break;
        }
    }


}
