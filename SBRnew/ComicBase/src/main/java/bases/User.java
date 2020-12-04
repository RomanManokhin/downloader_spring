package bases;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    private String name;
    private String password;
    private String role;


    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", role='" + role;
    }
}
