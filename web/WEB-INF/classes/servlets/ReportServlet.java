package servlets;

import entitys.Movie;
import services.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PloSkiY on 06.05.2017.
 */
@WebServlet("/getreport")
public class ReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Movie movie = MovieService.getInstance().details(Long.valueOf(req.getParameter("id"))).get();
        resp.setHeader("Content-disposition", "attachment; filename = " + movie.getId() + ".txt");
        resp.getWriter().write(movie.getTitle() + "\n \n" +
                " " + movie.getDescription());
    }
}
