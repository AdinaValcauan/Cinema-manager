package dao;

import connection.ConnectionFactory;
import model.Admin;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDAO {
    protected static final Logger LOGGER = Logger.getLogger(AdminDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO admin (id_admin,position)"
            + " VALUES (?,?)";
    private static final String insertStatementString1 = "INSERT INTO person (id_person, email, first_name, last_name, username, password)"
            + " VALUES (?,?,?,?,?,?)";

    public static int insert(Admin admin) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        PreparedStatement insertStatement1 = null;
        int insertedId = -1;
        try {
            insertStatement1 = dbConnection.prepareStatement(insertStatementString1, Statement.RETURN_GENERATED_KEYS);
            insertStatement1.setInt(1, admin.getId_person());
            insertStatement1.setString(2, admin.getEmail());
            insertStatement1.setString(3, admin.getFirst_name());
            insertStatement1.setString(4, admin.getLast_name());
            insertStatement1.setString(5, admin.getUsername());
            insertStatement1.setString(6, admin.getPassword());
            insertStatement1.executeUpdate();

            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, admin.getId_admin());
            insertStatement.setString(2, admin.getPosition());
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
