package servlets;

import services.MovieMemberService;
import services.MovieService;
import services.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandr on 06.05.2017.
 */
@WebServlet("/member-details")
public class MemberDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("member", MovieMemberService.getInstance().getMovieMemberById(Long.valueOf(req.getParameter("id"))).get());
        req.setAttribute("memberFilm", MovieService.getInstance().getMovieByMemberId(Long.valueOf(req.getParameter("id"))).get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/member-details.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
