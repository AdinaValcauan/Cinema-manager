package model;

public class Movies {
    private int id_movies;
    private String title;
    private int release_year;
    private String producer;
    private int id_genre;

    public Movies(int id_movies, String title, int release_year, String producer, int id_genre){
        this.id_movies = id_movies;
        this.title = title;
        this.release_year = release_year;
        this.producer = producer;
        this.id_genre = id_genre;
    }

    public int getId_movies(){
        return id_movies;
    }

    public void setId_movies(int id_movies){
        this.id_movies = id_movies;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getId_genre(){
        return id_genre;
    }

    public void setId_genre(int id_genre){
        this.id_genre = id_genre;
    }
}
