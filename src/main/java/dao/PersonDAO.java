package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Person;

public class PersonDAO {
    protected static final Logger LOGGER = Logger.getLogger(MoviesDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO person (id_person, email, first_name, last_name, username, password)"
            + " VALUES (?,?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM person where id = ?";

    public static int insert(Person person) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, person.getId_person());
            insertStatement.setString(2, person.getEmail());
            insertStatement.setString(3, person.getFirst_name());
            insertStatement.setString(4, person.getLast_name());
            insertStatement.setString(5, person.getUsername());
            insertStatement.setString(6, person.getPassword());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "PersonDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
}
