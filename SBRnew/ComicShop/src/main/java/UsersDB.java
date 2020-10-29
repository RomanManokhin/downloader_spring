import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsersDB implements Serializable {

    static Map<String, User> userDB = new HashMap<>();

    static {
        userDB.put("admin", new User("admin", "admin", "admin"));
        userDB.put("user", new User("user", "user", "user"));
    }

    static void userCreate() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите логин: ");
            String newLogin = in.next();
            if (userDB.containsKey(newLogin)) {
                System.out.println("Такой пользователь существует");
                continue;
            }
            System.out.println("Введите пароль: ");
            String newPassword = in.next();
            System.out.println("Повторите пароль: ");
            String newPasswordTest = in.next();
            if (newPassword.equals(newPasswordTest)) {
                userDB.put(newLogin, new User(newLogin, newPasswordTest, "user"));
                System.out.println("Пользователь " + newLogin + " создан");
                break;
            } else {
                System.out.println("Пароли не совпадают");
            }
        }
    }

    public static String start(String login) {
        String role = "wrong";

            Scanner in = new Scanner(System.in);
            if (!userDB.containsKey(login)) {
                System.out.println("Такой пользователь не найден в системе");
                System.out.println("Выберите что необходимо сделать: ");
                System.out.println("1. Повторить ввод данных");
                System.out.println("2. Создать нового пользователя");
                boolean isInt = in.hasNextInt();
                if (isInt) {
                    int choice = in.nextInt();
                    switch (choice) {
                        case 1: {
                            break;
                        }
                        case 2: {
                            userCreate();
                            break;
                        }
                    }
                } else {
                    System.out.println("Неверный ввод");
                }
            } else {
                role = autorization(login);

            }

        return role;
    }

    static String autorization(String login) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Введите пароль: ");
            String password = in.next();

            String role = userDB.get(login).getPassword().equals(password) ? userDB.get(login).getRole() : "wrong";


            if (!role.equals("wrong")) {
                return role;
            }
        }

    }


}
