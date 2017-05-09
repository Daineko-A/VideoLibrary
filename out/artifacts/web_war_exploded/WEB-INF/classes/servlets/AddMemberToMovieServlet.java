package servlets;

import entitys.Movie;
import services.MovieMemberService;
import services.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by PloSkiY on 08.05.2017.
 */
@WebServlet("/add-member-to-movie")
public class AddMemberToMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userRole").equals("admin")){
            req.setAttribute("role", 1);
        }
        req.setAttribute("movies", MovieService.getInstance().showAll(0, 50).get());
        req.setAttribute("movieMembers", MovieMemberService.getInstance().getAllMember().get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-member-to-movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("dropdownChoiceMembers").length != 0 || !req.getParameter("dropdownChoiceMovie").equals("") || !req.getParameter("role").equals("")){
            MovieMemberService.getInstance().addMemberToMovie(
                    req.getParameterValues("dropdownChoiceMembers"), Long.valueOf(req.getParameter("dropdownChoiceMovie")), req.getParameter("role"));
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-member-to-movie.jsp").forward(req, resp);
    }
}
