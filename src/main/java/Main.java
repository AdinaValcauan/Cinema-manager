import dao.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        //Person person = new Person(2, "add@yahoo.com", "darius", "dragus", "ddaboy", "1234");
        //PersonDAO.insert(person);

        //Genres genres = new Genres(1, "romance");
        //GenresDAO.insert(genres);
        //Genres genres1 = new Genres(2, "animation");
        //GenresDAO.insert(genres1);

        //Movies movies = new Movies(1, "Once upon a time", 2017, "Steven Jobs", 2);
        //MoviesDAO.insert(movies);

        //Seats seats = new Seats(1,1,1);
        //SeatsDAO.insert(seats);

        //Admin admin = new Admin(6,"anaa@yahoo.com","Ana","Vasilache","anaaV","ana123","seller");
        //AdminDAO.insert(admin);

        //MoviesDAO.viewAll();
        //GenresDAO.viewAll();

        Reservations reservations = new Reservations(2,5,1,3);
        ReservationsDAO.insert(reservations);

        //Users users = new Users(7,"ionutpop@gmail.com","Ionut","Pop","ionu","pi78", "1 month");
        //UsersDAO.insert(users);
    }
}
