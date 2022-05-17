package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Seats;

public class SeatsDAO {
    protected static final Logger LOGGER = Logger.getLogger(SeatsDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO seats (id_seats,row,column)"
            + " VALUES (?,?,?)";

    public static int insert(Seats seats) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, seats.getId_seats());
            insertStatement.setInt(2, seats.getRow());
            insertStatement.setInt(3, seats.getColumn());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "SeatsDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
}
