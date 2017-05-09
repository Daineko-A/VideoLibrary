package dao;

import entitys.ConnectionManager;
import entitys.Movie;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class MovieDao {
    private final static Object LOCK = new Object();
    private static MovieDao INSTANCE = null;

    public static MovieDao getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new MovieDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<List<Movie>> showAll(long startRow, long limit){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT movies.id, movies.title, genre.genre FROM movies\n" +
                            "\tLEFT JOIN genre ON movies.genre_id = genre.id\n" +
                            "    ORDER BY release_date DESC LIMIT ?, ?;")){
                preparedStatement.setLong(1, startRow);
                preparedStatement.setLong(2, limit);
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                while (resultSet.next()){
                    moviesList.add(new Movie(resultSet.getInt("movies.id"), resultSet.getString("movies.title"),
                            resultSet.getString("genre.genre")));
                }
                return Optional.of(moviesList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> details(long id){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT movies.id, movies.title, movies.release_date, movies.description, genre.genre, country.country FROM movies\n" +
                            "\tLEFT JOIN genre ON movies.genre_id = genre.id\n" +
                            "    LEFT JOIN country ON movies.country_id = country.id\n" +
                            "    WHERE movies.id = ?;")){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return Optional.of(new Movie(resultSet.getInt("id"), resultSet.getString("movies.title"),
                        resultSet.getDate("movies.release_date").toLocalDate(), resultSet.getString("movies.description"),
                            resultSet.getString("genre.genre"), resultSet.getString("country.country")));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> addMovie(Movie movie, long genreId, long countryId){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies (title, genre_id, release_date, country_id, description) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setLong(2, genreId);
                preparedStatement.setString(3, movie.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                preparedStatement.setLong(4, countryId);
                preparedStatement.setString(5, movie.getDescription());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    return Optional.of(movie);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //movieMember.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    public Optional<Movie> getMovieById(long id){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE id = ?")){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return Optional.of(new Movie(resultSet.getLong("id"), resultSet.getString("title")));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Movie>> findMovie(String namePart) {
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE title LIKE ?")){
                preparedStatement.setString(1, "%" + namePart + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                while (resultSet.next()){
                    moviesList.add(new Movie(resultSet.getInt("movies.id"), resultSet.getString("movies.title")));
                }
                return Optional.of(moviesList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Movie>> findMovieByYear(long year) {
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE release_date LIKE ?")){
                preparedStatement.setString(1, year + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                while (resultSet.next()){
                    moviesList.add(new Movie(resultSet.getInt("movies.id"), resultSet.getString("movies.title"),
                            resultSet.getDate("release_date").toLocalDate()));
                }
                return Optional.of(moviesList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public long getCountryIdByName(String country){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM country WHERE country = ?")){
                preparedStatement.setString(1, country);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public long addCountry(String country){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO country (country) VALUES (?);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, country);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                while (generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public long getGenreIdByName(String genre){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM genre WHERE genre = ?")){
                preparedStatement.setString(1, genre);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public long addGenre(String genre){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO genre (genre) VALUES (?);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, genre);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                while (generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void findFilmMember(String namePart){

    }

    public Optional<List<Movie>> getMovieByMemberId(long memberId){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT movies.id, movies.title, roles.role, genre.genre FROM movies\n" +
                            "LEFT JOIN movies_members_roles ON movies.id = movies_members_roles.movie_id\n" +
                            "LEFT JOIN genre ON genre.id = movies.genre_id\n" +
                            "LEFT JOIN roles ON movies_members_roles.role_id = roles.id\n" +
                            "WHERE movies_members_roles.member_id = ?;")){
                preparedStatement.setLong(1, memberId);
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                while (resultSet.next()){
                    moviesList.add(new Movie(resultSet.getInt("movies.id"), resultSet.getString("movies.title"),
                            resultSet.getString("genre.genre")));
                }
                return Optional.of(moviesList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
