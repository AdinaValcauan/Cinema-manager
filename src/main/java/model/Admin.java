package model;

public class Admin extends Person{
    private int id_admin;
    private String position;

    public Admin(int id_person, String email, String first_name, String last_name, String username, String password /*int id_admin*/, String position){
        super(id_person,email,first_name,last_name,username,password);
        this.id_admin = id_person;
        this.position = position;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_person) {
        this.id_admin = id_person;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
