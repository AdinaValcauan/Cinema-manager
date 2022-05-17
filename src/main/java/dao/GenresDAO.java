package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Genres;
import model.Movies;


public class GenresDAO {
    protected static final Logger LOGGER = Logger.getLogger(GenresDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO genres (id_genres,type)"
            + " VALUES (?,?)";
    private final static String viewAllStatementString = "SELECT * FROM genres";

    public static int insert(Genres genres) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, genres.getId_genres());
            insertStatement.setString(2, genres.getType());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GenresDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static Genres viewAll() {
        Genres toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = findStatement.executeQuery();
            rs.next();

            int id_genres = rs.getInt("id_genres");
            String type = rs.getString("type");
            toReturn = new Genres(id_genres,type);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GenresDAO:viewAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}
