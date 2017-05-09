package dao;

import entitys.ConnectionManager;
import entitys.Movie;
import entitys.MovieMember;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class MovieMemberDao {
    private final static Object LOCK = new Object();
    private static MovieMemberDao INSTANCE = null;

    public static MovieMemberDao getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new MovieMemberDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<MovieMember> addMovieMember(MovieMember movieMember){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO members (first_name, last_name, birthday) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, movieMember.getFirstName());
                preparedStatement.setString(2, movieMember.getLastName());
                preparedStatement.setString(3, movieMember.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                preparedStatement.executeUpdate();
                ResultSet genKeys = preparedStatement.getGeneratedKeys();
                if(genKeys.next()){
                    return Optional.of(movieMember);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public long getMemberByFullName(String firstName, String lastName){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM members WHERE first_name = ? AND last_name = ?")){
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                  return resultSet.getLong("id");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public Optional<List<MovieMember>> getAllMember(){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM members")){

                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<MovieMember> movieMembersList = new ArrayList<MovieMember>();
                while (resultSet.next()){
                    movieMembersList.add(new MovieMember(resultSet.getLong("id"), resultSet.getString("first_name"),
                            resultSet.getString("last_name"), resultSet.getDate("birthday").toLocalDate() ));
                }
                return Optional.of(movieMembersList);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public long getRoleIdByName(String role){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM roles WHERE role = ?")){
                preparedStatement.setString(1, role);
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

    public long addRole(String role){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO roles (role) VALUES (?);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, role);
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

    public Optional<List<MovieMember>> getMovieMembersByMovieId(long movieId){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT members.id, members.first_name, members.last_name," +
                    " members.birthday, roles.role FROM members\n" +
                    "LEFT JOIN movies_members_roles ON members.id = movies_members_roles.member_id \n" +
                    "LEFT JOIN roles ON movies_members_roles.role_id = roles.id\n" +
                    "WHERE movies_members_roles.movie_id = ?;")){
                preparedStatement.setLong(1, movieId);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<MovieMember> movieMemberList = new ArrayList<MovieMember>();
                while (resultSet.next()){
                    movieMemberList.add(new MovieMember(resultSet.getLong("members.id"), resultSet.getString("members.first_name"),
                             resultSet.getString("members.last_name"), resultSet.getDate("members.birthday").toLocalDate(), resultSet.getString("roles.role")));
                }
                return Optional.of(movieMemberList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<MovieMember> getMovieMemberById(long id){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM members WHERE id = ?;")){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    return Optional.of(new MovieMember(id, resultSet.getString("first_name"),
                            resultSet.getString("last_name"), resultSet.getDate("birthday").toLocalDate()));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean addMemberToMovie(long memberId, long movieId, long roleId){
        try(Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies_members_roles (movie_id, member_id, role_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setLong(1, movieId);
                preparedStatement.setLong(2, memberId);
                preparedStatement.setLong(3, roleId);
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(!resultSet.next()){
                    return true;
                }
            }
        }catch (SQLException e){
            return false;
        }
        return false;
    }


}
