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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by PloSkiY on 17.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println(MovieMemberDao.getInstance().getMovieMemberById(2).get());


//        LocalDate first = LocalDate.of(2020, 06, 25);
//        System.out.println(first);
//
//        LocalDate second = LocalDate.now();
//        LocalDate secondNew = second.plusMonths(3);
//        System.out.println(secondNew);
//
//
//        LocalDate nowToString = LocalDate.now();
//        System.out.println(nowToString.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
//
//        String date = "26-03-2014";
//        LocalDate stringToLD = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        System.out.println(stringToLD);
//
//        LocalTime lt = LocalTime.of(0,0);
//        LocalDate nowDate = LocalDate.now();
//        LocalDateTime ldNow = LocalDateTime.of(nowDate, lt);
//
//        LocalDate ld = LocalDate.of(2020, 06, 25);
//        LocalDateTime fitureDate = LocalDateTime.of(ld, lt);
//        Duration dif = Duration.between(ldNow, fitureDate);
//        System.out.println(dif.toDays());
//
//        System.out.println(dif.getSeconds());



//        System.out.println(ReviewService.getInstance().getRating(1));

//        for(MovieMember mm: MovieMemberDao.getInstance().getMovieMembersByMovieId(1).get()){
//            System.out.println(mm);
//        }

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
