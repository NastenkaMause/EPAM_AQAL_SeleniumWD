package User;

public class UserFactory {
    public static User getValidUser(){
        return new User("NastenkaMause", "NastenkaMuse@i.ua","hilfehilfe","i.ua");
    }
    public static User getNotValidUser(){
        return new User("NastenkaMause", "NastenkaMuse@i.ua","NastenkaMuse","i.ua");
    }
}
