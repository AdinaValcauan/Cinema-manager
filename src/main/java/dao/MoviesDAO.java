package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Movies;

public class MoviesDAO {
    protected static final Logger LOGGER = Logger.getLogger(MoviesDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO movies (id_movies, title,release_year,producer,id_genre)"
            + " VALUES (?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM movies where id = ?";
    private final static String viewAllStatementString = "SELECT * FROM movies";

    public static Movies findById(int id_movies) {
        Movies toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, id_movies);
            rs = findStatement.executeQuery();
            rs.next();

            String title = rs.getString("title");
            int release_year = rs.getInt("release_year");
            String producer = rs.getString("producer");
            int id_genre = rs.getInt("id_genre");
            toReturn = new Movies(id_movies, title, release_year, producer, id_genre);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"MovieDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static int insert(Movies movies) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, movies.getId_movies());
            insertStatement.setString(2, movies.getTitle());
            insertStatement.setInt(3, movies.getRelease_year());
            insertStatement.setString(4, movies.getProducer());
            insertStatement.setInt(5, movies.getId_genre());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MoviesDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static Movies viewAll() {
        Movies toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = findStatement.executeQuery();
            rs.next();

            int id_movies = rs.getInt("id_movies");
            String title = rs.getString("title");
            int release_year = rs.getInt("release_year");
            String producer = rs.getString("producer");
            int id_genre = rs.getInt("id_genre");
            toReturn = new Movies(id_movies, title, release_year, producer, id_genre);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"MoviesDAO:viewAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}
