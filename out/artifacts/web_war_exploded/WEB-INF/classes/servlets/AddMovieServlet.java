package servlets;

import entitys.Movie;
import entitys.MovieMember;
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

@WebServlet("/add-movie")
public class AddMovieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("date", LocalDate.now().toString());
//        req.setAttribute("members", MovieMemberService.getInstance().getAllMember().get());
        if(req.getSession().getAttribute("userRole").equals("admin")){
            req.setAttribute("role", 1);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-new-movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!req.getParameter("title").equals("") || !req.getParameter("releaseDate").equals("") || !req.getParameter("description").equals("") ||
                !req.getParameter("genre").equals("") || !req.getParameter("country").equals("")){
            MovieService.getInstance().addMovie(new Movie(req.getParameter("title"),
                            LocalDate.parse(req.getParameter("releaseDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")), req.getParameter("description")),
                    req.getParameter("genre"), req.getParameter("country"));
//            resp.sendRedirect("/add-member-to-movie");
        }


        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-new-movie.jsp").forward(req, resp);
//        resp.sendRedirect("/add-member-to-movie");
    }
}
