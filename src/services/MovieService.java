package services;

import dao.MovieDao;
import entitys.Movie;

import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 19.04.2017.
 */
public class MovieService {

    private final static Object LOCK = new Object();
    private static MovieService INSTANCE = null;

    public static MovieService getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new MovieService();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<List<Movie>> showAll(int startRow, int limit){
        return MovieDao.getInstance().showAll(startRow, limit);
    }

    public Optional<Movie> details(long id){
        return MovieDao.getInstance().details(id);
    }

    public Optional<Movie> getMovieById(long id){
        return MovieDao.getInstance().getMovieById(id);
    }


    public Optional<List<Movie>> findMovie(String namePart){
        return MovieDao.getInstance().findMovie(namePart);
    }

    public Optional<List<Movie>> findMovieByYear(long year) {
        return MovieDao.getInstance().findMovieByYear(year);
    }

    public void findFilmMember(String namePart){

    }
}
