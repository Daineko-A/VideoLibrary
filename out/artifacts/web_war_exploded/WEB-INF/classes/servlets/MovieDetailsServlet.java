package servlets;

import entitys.Review;
import services.MovieMemberService;
import services.MovieService;
import services.ReviewService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PloSkiY on 24.04.2017.
 */
@WebServlet("/movie-details")
public class MovieDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("movie", MovieService.getInstance().details(id).get());
        req.setAttribute("review", ReviewService.getInstance().showAllReview(id).get());
        req.setAttribute("rating", ReviewService.getInstance().getRating(id));
        req.setAttribute("movieMembers", MovieMemberService.getInstance().getMovieMembersByMovieId(id).get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/movie-details.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewService.getInstance().addReview(req.getParameter("reviewtext"),Long.valueOf(req.getParameter("review_stars")),
                 req.getSession().getAttribute("userName").toString(), Long.valueOf(req.getParameter("id")));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
