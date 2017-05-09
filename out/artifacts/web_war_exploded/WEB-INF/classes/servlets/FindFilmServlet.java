package servlets;

import services.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PloSkiY on 25.04.2017.
 */
@WebServlet("/find-film")
public class FindFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("movies", MovieService.getInstance().findMovie(req.getParameter("namePart")).get());
        if (req.getParameter("year") != null){
            req.setAttribute("movies", MovieService.getInstance().findMovieByYear(Long.valueOf(req.getParameter("year"))).get());
        }
        if(req.getSession().getAttribute("userRole").equals("admin")){
            req.setAttribute("role", 1);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/find-film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("movies", MovieService.getInstance().findMovie(req.getParameter("namePart")).get());
        req.setAttribute("movies", MovieService.getInstance().findMovieByYear(Long.valueOf(req.getParameter("year"))).get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/find-film.jsp").forward(req, resp);
    }
}
