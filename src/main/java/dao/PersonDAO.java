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
            insertStatement.setString(3, person.getFirstName());
            insertStatement.setString(4, person.getLastName());
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

    public static boolean checkCredentials(String username, char[] password) {
        boolean result = false;
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE username = '" + username + "' AND password = '" + new String(password) + "'");
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while checking the credentials");
            e.printStackTrace();
        }
        ConnectionFactory.close(connection);
        return result;
    }
}
