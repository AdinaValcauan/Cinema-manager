package model;

public class Reservations {
    private int id_reservations;
    private int id_person;
    private int id_movies;
    private int id_seats;

    public Reservations(int id_reservations, int id_person, int id_movies, int id_seats){
        this.id_reservations = id_reservations;
        this.id_person = id_person;
        this.id_movies = id_movies;
        this.id_seats = id_seats;
    }

    public int getId_reservations(){
        return id_reservations;
    }

    public void setId_reservations(int id_reservations){
        this.id_reservations = id_reservations;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getId_movies(){
        return id_movies;
    }

    public void setId_movies(int id_movies){
        this.id_movies = id_movies;
    }

    public int getId_seats(){
        return id_seats;
    }

    public void setId_seats(int id_seats){
        this.id_seats = id_seats;
    }
}
