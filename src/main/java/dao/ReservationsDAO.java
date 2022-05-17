package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Reservations;

public class ReservationsDAO {
    protected static final Logger LOGGER = Logger.getLogger(ReservationsDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO reservations (id_reservations,id_person, id_movies, id_seats)"
            + " VALUES (?,?,?,?)";
    //private final static String findStatementString = "SELECT * FROM reservations where id = ?";

    public static int insert(Reservations reservations) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, reservations.getId_reservations());
            insertStatement.setInt(2, reservations.getId_person());
            insertStatement.setInt(3, reservations.getId_movies());
            insertStatement.setInt(4, reservations.getId_seats());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ReservationsDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
}
