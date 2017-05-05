import dao.MovieDao;
import dao.MovieMemberDao;
import dao.UserDao;
import entitys.Movie;
import entitys.MovieMember;
import entitys.User;
import services.MovieMemberService;
import services.MovieService;
import services.ReviewService;
import services.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by PloSkiY on 17.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        for(MovieMember mm: MovieMemberDao.getInstance().getMovieMembersByMovieId(1).get()){
            System.out.println(mm);
        }

//        System.out.println(ReviewService.getInstance().getRating(1));

//        if (UserDao.getInstance().getUser("admin", "admin").isPresent()){
//            User user = UserDao.getInstance().getUser("admin", "admin").get();
//            System.out.println(user);
//        }

//        UserDao.getInstance().newUser(new User("Tihan1", "12345", "tihan1@deadline.close"));
//        UserDao.getInstance().getIdbyUserRole("user");
//        System.out.println(UserDao.getInstance().getUserByName("admin"));
//        System.out.println(UserService.getInstance().getUserByName("admin"));
//            Movie movie = MovieService.getInstance().details(1).get();
//            System.out.println(MovieService.getInstance().details(1).get());

//        System.out.println(MovieDao.getInstance().addCountry("США"));
//        System.out.println(MovieDao.getInstance().findMovie("а").get());

//        for (Movie movie : MovieService.getInstance().findMovieByYear(2017).get()) {
//            System.out.println(movie.getTitle());
//        }

//        System.out.println(Long.valueOf(LocalDate.now().toString(), 4));

//        MovieMember movieMember = new MovieMember("Евгений", "Миронов", LocalDate.parse("1966-11-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        System.out.println(MovieMemberService.getInstance().addMovieMember(movieMember));
//        String role = "актер";
//
//        if ( MovieMemberDao.getInstance().getRoleIdByName(role) == 0) {
//            MovieMemberDao.getInstance().addRole(role);
//        }

//        for (MovieMember mm : MovieMemberDao.getInstance().getAllMember().get()) {
//            System.out.println(mm);
//        }
    }
}
