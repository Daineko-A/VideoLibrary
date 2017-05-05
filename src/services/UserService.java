package services;

import dao.UserDao;
import entitys.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 19.04.2017.
 */
public class UserService {

    private final static Object LOCK = new Object();
    private static UserService INSTANCE = null;

    public static UserService getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<User> newUser(User user){
        return UserDao.getInstance().newUser(user);
    }

//    public Optional<User> getUserByName(String name){
//        return UserDao.getInstance().getUserByName(name);
//    }

    public Optional<User> getUserByName(String name){
        return UserDao.getInstance().getUserByName(name);
    }

    public Optional<List<User>> getAllUser(int start, int end){
        return UserDao.getInstance().getAllUser(start, end);
    }

    public Optional<User> getUserById(Long id){
        return UserDao.getInstance().getUserById(id);
    }

    public Optional<User> getUser(String login, String pass){
        return UserDao.getInstance().getUser(login, pass);
    }

//    public Optional<User> autorization(String Login, String pass){
//        return UserDao.getInstance().autorization(Login, pass);
//    }


    public void findUser(String namePart){

    }


}
