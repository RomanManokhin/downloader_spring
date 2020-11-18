import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsersDB implements Serializable {
    static Map<String, User> userDB = new HashMap<>();

    static {
        userDB.put("admin", new User("admin", "admin", "admin"));
        userDB.put("user", new User("user", "user", "user"));

        File file = new File("loginData.txt");
        if (!file.isFile()) {
            Serialization.serializationObject(userDB, "loginData.txt");
        }

    }

    static void userCreate() {
//        userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
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
                Serialization.serializationObject(userDB, "loginData.txt");
                break;
            } else {
                System.out.println("Пароли не совпадают");
            }
        }
    }

    public static String start(String login) {
        String role = "wrong";
        userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
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
            role = authorization(login);
        }
        return role;
    }

    static String authorization(String login) {
        Scanner in = new Scanner(System.in);
        userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
        while (true) {
            System.out.print("Введите пароль: ");
            String password = in.next();
            String role = userDB.get(login).getPassword().equals(password) ? userDB.get(login).getRole() : "wrong";
            if (!role.equals("wrong")) {
                return role;
            }
        }
    }


    static String changeRole(String login) {
        Scanner in = new Scanner(System.in);
        userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
        System.out.println(DeSerialization.deSerialization("loginData.txt"));
        System.out.println("Какому пользователю необходимо изменить права?\nИли 0 для отмены");
        String changedName = in.next();
        if (changedName.equals("0")) {
            return "Отмена";
        } else {
            if (userDB.containsKey(changedName)) {
                if (userDB.get(changedName).getRole().equals("user")) {
                    userDB.get(changedName).setRole("admin");
                    Serialization.serializationObject(userDB, "loginData.txt");
                    if (userDB.get(login).getName().equals(changedName)) {
                        System.out.println("Роль изменана на : admin, перезайдите в программу");
                        System.exit(0);
                    } else {
                        return "Роль изменана на : admin";
                    }
                } else {
                    userDB.get(changedName).setRole("user");
                    Serialization.serializationObject(userDB, "loginData.txt");
                    if (userDB.get(login).getName().equals(changedName)) {
                        System.out.println("Роль изменана на : user, перезайдите в программу");
                        System.exit(0);
                    } else {
                        return "Роль изменана на : user";
                    }
                }
            } else {
                return "Введён не верный логин";
            }
        }
        return "этой строчки не должно быть";
    }

    static String deleteUser() {
        Scanner in = new Scanner(System.in);
        userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
        System.out.println(DeSerialization.deSerialization("loginData.txt"));
        System.out.println("Какого пользователя необходимо удалить\nИли 0 для отмены");
        String deleteName = in.next();
        if (deleteName.equals("0")) {
            return "Выход";
        } else {
            if (userDB.containsKey(deleteName)) {
                userDB.remove(deleteName);
                Serialization.serializationObject(userDB, "loginData.txt");
                userDB = (Map<String, User>) DeSerialization.deSerialization("loginData.txt");
            } else {
                return "Нет такого пользователя";
            }
        }
        return "Пользователь " + deleteName + " удалён";
    }
}
