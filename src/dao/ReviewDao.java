package dao;

import entitys.ConnectionManager;
import entitys.Movie;
import entitys.Review;
import entitys.User;
import services.MovieService;
import services.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class ReviewDao {
    private final static Object LOCK = new Object();
    private static ReviewDao INSTANCE = null;

    public static ReviewDao getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new ReviewDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<List<Review>> showAllReview(long idMovie){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM review WHERE movie_id = ?;")){
                preparedStatement.setLong(1, idMovie);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Review> reviewsList = new ArrayList<Review>();

                while (resultSet.next()){
                    reviewsList.add(new Review(resultSet.getLong("id"), resultSet.getString("text"), resultSet.getDate("date").toLocalDate(),
                            resultSet.getLong("stars"), UserService.getInstance().getUserById(resultSet.getLong("user_id")).get(),
                            MovieService.getInstance().getMovieById(resultSet.getLong("movie_id")).get()));
                }
                return Optional.of(reviewsList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Review> addReview(Review review){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO review (text, date, stars, user_id, movie_id) VALUES ( ?, localtime , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, review.getText());
                preparedStatement.setLong(2, review.getStars());
                preparedStatement.setLong(3, review.getUser().getId());
                preparedStatement.setLong(4, review.getMovie().getId());
                preparedStatement.executeUpdate();
                ResultSet genKey = preparedStatement.getGeneratedKeys();
                if(genKey.next()){
                    return Optional.of(review);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
