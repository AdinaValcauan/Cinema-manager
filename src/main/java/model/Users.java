package model;

public class Users extends Person{
    private int id_users;
    private String subscription;

    public Users(int id_person, String email, String first_name, String last_name, String username, String password, String subscription){
        super(id_person, email, first_name, last_name, username, password);
        this.id_users = id_person;
        this.subscription = subscription;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_person) {
        this.id_users = id_person;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
}
