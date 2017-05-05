package services;

import dao.ReviewDao;
import entitys.Review;

import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 19.04.2017.
 */
public class ReviewService {

    private final static Object LOCK = new Object();
    private static ReviewService INSTANCE = null;

    public static ReviewService getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new ReviewService();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<List<Review>> showAllReview(long idMovie){
        return ReviewDao.getInstance().showAllReview(idMovie);
    }

    public Optional<Review> addReview(String textReview, long stars, String userName, long movieId){
        return ReviewDao.getInstance().addReview(new Review(textReview, stars,
                UserService.getInstance().getUserByName(userName).get(), MovieService.getInstance().getMovieById(movieId).get()));
    }

    public long getRating(long idMovie){
        long raiting = 0;
        List<Review> reviews = showAllReview(idMovie).get();

        for (Review review: reviews){
            raiting += review.getStars();
        }

        raiting = raiting / reviews.size();

        return raiting;
    }

}
