package services;

import dao.MovieMemberDao;
import entitys.MovieMember;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 27.04.2017.
 */
public class MovieMemberService {

    private final static Object LOCK = new Object();
    private static MovieMemberService INSTANCE = null;

    public static MovieMemberService getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if(INSTANCE == null){
                    INSTANCE = new MovieMemberService();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<MovieMember> addMovieMember(MovieMember movieMember){
        long memberId = MovieMemberDao.getInstance().getMemberByFullName(movieMember.getFirstName(), movieMember.getLastName());

        if(memberId == 0){
            movieMember = MovieMemberDao.getInstance().addMovieMember(movieMember).get();
        } else {
            movieMember = getMovieMemberById(memberId).get();   
        }

        return Optional.of(movieMember);
    }

    public Optional<List<MovieMember>> getAllMember(){
        return MovieMemberDao.getInstance().getAllMember();
    }

    public long addRole(String role){
        if ( MovieMemberDao.getInstance().getRoleIdByName(role) == 0) {
            MovieMemberDao.getInstance().addRole(role.trim().toLowerCase());
        }
        return MovieMemberDao.getInstance().getRoleIdByName(role);
    }

    public Optional<List<MovieMember>> getMovieMembersByMovieId(long movieId){
        return MovieMemberDao.getInstance().getMovieMembersByMovieId(movieId);
    }

    public Optional<MovieMember> getMovieMemberById(long id){
        return MovieMemberDao.getInstance().getMovieMemberById(id);
    }

    public boolean addMemberToMovie(String[] memberId, long movieId, String role){
        boolean isAdd = false;
        if (memberId.length != 0){
            for (String strMemberId : memberId){
                MovieMemberDao.getInstance().addMemberToMovie(Long.valueOf(strMemberId), movieId, addRole(role));
            }
            isAdd = true;
        }
        return isAdd;
    }
}
