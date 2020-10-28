import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UsersDB implements Serializable {

    Map<String, User> userDB = new HashMap<>();

    void userFactory(){
        userDB.put("admin", new User("admin", "admin", "admin"));
        userDB.put("user", new User("user", "user", "user"));
    }

    void userCreate(String name, String nameUser, String password, String role){
        userDB.put(name, new User(nameUser, password, role));
    }

    public Map<String, User> getUserDB() {
        return userDB;
    }
}
