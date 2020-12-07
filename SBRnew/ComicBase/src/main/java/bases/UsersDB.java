package bases;

import serrialization.Serialization;
import start.StartProgram;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsersDB implements Serializable {
    private Map<String, User> userDB = new HashMap<>();
    Scanner in = new Scanner(System.in);
    Serialization serialization = new Serialization();

    public void userDBInit() {
        userDB.put("admin", new User("admin", "admin", "admin"));
        userDB.put("user", new User("user", "user", "user"));

        File file = new File("loginData.txt");
        if (!file.isFile()) {
            serialization.serialization(userDB, "loginData.txt");
        } else {
            serialization.deSerialization("loginData.txt");
        }

    }

    public void userCreate() {
        while (true) {
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
                serialization.serialization(userDB, "loginData.txt");
                break;
            } else {
                System.out.println("Пароли не совпадают");
            }
        }
    }

    public String start(String login) {
        String role = "wrong";
        userDB = (Map<String, User>) serialization.deSerialization("loginData.txt");
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

    public String authorization(String login) {
        userDB = (Map<String, User>) serialization.deSerialization("loginData.txt");
        while (true) {
            System.out.print("Введите пароль: ");
            String password = in.next();
            String role = userDB.get(login).getPassword().equals(password) ? userDB.get(login).getRole() : "wrong";
            if (!role.equals("wrong")) {
                return role;
            }
        }
    }


    public boolean changeRole(String nameChange, String login) {
        if (userDB.containsKey(nameChange)) {
            if (userDB.get(nameChange).getRole().equals("user")) {
                userDB.get(nameChange).setRole("admin");
            } else {
                userDB.get(nameChange).setRole("user");
            }
            serialization.serialization(userDB, "loginData.txt");
            if (userDB.get(nameChange).getName().equals(login)) {
                new StartProgram().init();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(String deleteName, String login) {
        if (userDB.containsKey(deleteName)) {
            userDB.remove(deleteName);
            serialization.serialization(userDB, "loginData.txt");
            return true;
        } else {
            return false;
        }
    }

    public Map<String, User> getUserDB() {
        return userDB;
    }
}
