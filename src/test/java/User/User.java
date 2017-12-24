package User;

public class User {
    public String name;
    public String login;
    public String password;
    public String domain;

    public User(String name, String login, String password, String domain) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "User to = " + name + ", subject = " + login + ", body = " + password + ", domain = " + domain;
    }
}
