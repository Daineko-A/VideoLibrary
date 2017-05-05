package servlets;

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

@WebServlet("/add-movie")
public class AddMovie extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("date", LocalDate.now().toString());
        req.setAttribute("members", MovieMemberService.getInstance().getAllMember().get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-new-movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
