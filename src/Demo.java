import dao.UserDao;
import entitys.User;
import services.UserService;

/**
 * Created by PloSkiY on 17.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
//        UserDao.getInstance().newUser(new User("Tihan1", "12345", "tihan1@deadline.close"));
//        UserDao.getInstance().getIdbyUserRole("user");
//        System.out.println(UserDao.getInstance().getUserByName("admin"));
//        System.out.println(UserService.getInstance().getUserByName("admin"));
        for (User user: UserService.getInstance().getAllUser(1, 10).get()) {
            System.out.println(user.getName());
        }


    }
}
