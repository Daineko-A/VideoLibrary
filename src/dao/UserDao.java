package dao;

import entitys.ConnectionManager;
import entitys.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class UserDao {
    private final static Object LOCK = new Object();
    private static UserDao INSTANCE = null;

    public static UserDao getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<User> newUser(User user){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user (name, pass, email, user_role_id) VALUES (?, ?, ?, 2);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.executeUpdate();
                ResultSet genKeys = preparedStatement.getGeneratedKeys();
                if(genKeys.next()){
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

//    public Optional<User> getUserByName(String name){
//        try(Connection connection = ConnectionManager.getConnection()){
//            try(PreparedStatement preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM user WHERE name = ?")){
//                preparedStatement.setString(1, name);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()){
//                    return Optional.of(new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("pass"),
//                            resultSet.getString("email"), resultSet.getInt("user_role_id")));
//                }
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

    public Optional<List<User>> getAllUser(int startRow, int limit){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user ORDER BY name LIMIT ?, ?")){
                preparedStatement.setInt(1, startRow);
                preparedStatement.setInt(2, limit);
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<User> usersList = new ArrayList<User>();
                while (resultSet.next()){
                    usersList.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("email"), getRoleById(resultSet.getLong("user_role_id"))));
                }
                return Optional.of(usersList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> getUserById(Long id){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user WHERE id = ?")){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return Optional.of(new User(resultSet.getLong("id"), resultSet.getString("name")));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> getUserByName(String name){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user WHERE name = ?")){
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return Optional.of(new User(resultSet.getLong("id"), resultSet.getString("name")));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> getUser(String login, String pass){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM user WHERE name = ? AND pass = ?")){
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, pass);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    return Optional.of(new User(resultSet.getLong("id"), login, getRoleById(resultSet.getLong("user_role_id"))));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public String getRoleById(long id){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_role WHERE id = ?")){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getString("role");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

//    public Optional<User> autorization(String Login, String pass){
//        try(Connection connection = ConnectionManager.getConnection()){
//            try(PreparedStatement preparedStatement = connection.prepareStatement(""))
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

}
