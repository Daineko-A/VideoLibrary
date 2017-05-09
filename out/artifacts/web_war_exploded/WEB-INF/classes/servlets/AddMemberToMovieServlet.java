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
//        req.setAttribute("movie", MovieService.getInstance().getMovieById(Long.valueOf(req.getParameter("id"))).get());
        req.setAttribute("movies", MovieService.getInstance().showAll(0, 50).get());
        req.setAttribute("movieMembers", MovieMemberService.getInstance().getAllMember().get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-member-to-movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieMemberService.getInstance().addMemberToMovie(req.getParameterValues(
                "dropdownChoiceMembers"), Long.valueOf(req.getParameter("dropdownChoiceMovie")), req.getParameter("role"));
//        MovieService.getInstance().addMovie(new Movie(req.getParameter("title"),
//                        LocalDate.parse(req.getParameter("releaseDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")), req.getParameter("description")),
//                req.getParameter("genre"), req.getParameter("country"));
//        System.out.println(req.getParameterValues("dropdownChoice"));

//        System.out.println(req.getParameter("dropdownChoiceMovie"));
//        for (String s:req.getParameterValues("dropdownChoiceMembers")){
//            System.out.println(s);
//        }
//        System.out.println(req.getParameter("id"));

//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-member-to-movie.jsp").forward(req, resp);
        resp.sendRedirect("/add-member-to-movie");

    }
}
