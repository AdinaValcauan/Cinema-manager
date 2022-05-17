package model;

public class Seats {
    private int id_seats;
    private int row;
    private int column;

    public Seats(int id_seats, int row, int column){
        this.id_seats = id_seats;
        this.row = row;
        this.column = column;
    }

    public int getId_seats(){
        return id_seats;
    }

    public void setId_seats(int id_seats){
        this.id_seats = id_seats;
    }

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }
}
