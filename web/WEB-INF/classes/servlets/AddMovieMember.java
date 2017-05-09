package servlets;

import entitys.MovieMember;
import services.MovieMemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by PloSkiY on 27.04.2017.
 */
@WebServlet("/add-movie-member")
public class AddMovieMember extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userRole").equals("admin")){
            req.setAttribute("role", 1);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-movie-member.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!req.getParameter("firstName").equals("") || !req.getParameter("lastName").equals("") || !req.getParameter("dateOfBirth").equals("")){
            MovieMemberService.getInstance().addMovieMember(new MovieMember(req.getParameter("firstName"), req.getParameter("lastName"),
                    LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movie/add-movie-member.jsp").forward(req, resp);
    }
}
