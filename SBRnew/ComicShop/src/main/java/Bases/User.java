package Bases;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public void reserveComic(ComicBase comicBase, UsersDB usersDB){

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
        return "User{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
