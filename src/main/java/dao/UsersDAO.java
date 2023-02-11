package dao;

import connection.ConnectionFactory;
import model.Users;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDAO {
    protected static final Logger LOGGER = Logger.getLogger(AdminDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO users (id_users,subscription)"
            + " VALUES (?,?)";
    private static final String insertStatementString1 = "INSERT INTO person (id_person, email, first_name, last_name, username, password)"
            + " VALUES (?,?,?,?,?,?)";

    public static int insert(Users users) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        PreparedStatement insertStatement1 = null;
        int insertedId = -1;
        try {
            insertStatement1 = dbConnection.prepareStatement(insertStatementString1, Statement.RETURN_GENERATED_KEYS);
            insertStatement1.setInt(1, users.getId_person());
            insertStatement1.setString(2, users.getEmail());
            insertStatement1.setString(3, users.getFirstName());
            insertStatement1.setString(4, users.getLastName());
            insertStatement1.setString(5, users.getUsername());
            insertStatement1.setString(6, users.getPassword());
            insertStatement1.executeUpdate();

            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, users.getId_users());
            insertStatement.setString(2, users.getSubscription());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "AdminDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
}
