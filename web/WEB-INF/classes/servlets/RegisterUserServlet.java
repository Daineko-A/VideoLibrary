package servlets;

import entitys.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PloSkiY on 17.04.2017.
 */
@WebServlet("/registration")
public class RegisterUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("loginreg").equals("") || !req.getParameter("passreg").equals("") || !req.getParameter("email").equals("")){
            UserService.getInstance().newUser(new User(req.getParameter("loginreg"), req.getParameter("passreg"), req.getParameter("email")));
        }
               
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users/login.jsp").forward(req, resp);
    }
}
