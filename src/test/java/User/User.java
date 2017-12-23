package User;

public class User {
    public String name;
    public String password;
    public String domain;

    public User(String name, String password, String domain) {
        this.name = name;
        this.password = password;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "User name = " + name + ", password = " + password + ", domain = " + domain;
    }
}
