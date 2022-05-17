package model;

public class Genres {
    private int id_genres;
    private String type;

    public Genres(int id_genres, String type){
        this.id_genres = id_genres;
        this.type = type;
    }

    public int getId_genres(){
        return id_genres;
    }

    public void setId_genres(int id_genres){
        this.id_genres = id_genres;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
