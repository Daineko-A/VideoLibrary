package servlets;

import entitys.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Alexandr on 06.05.2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> optionalUser = UserService.getInstance().getUser(req.getParameter("login"), req.getParameter("pass"));

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
        } else {
            doGet(req, resp);
            return;
        }

        req.getSession().setAttribute("userLoggedIn", true);
        req.getSession().setAttribute("userRole", optionalUser.get().getUserRole());
        req.getSession().setAttribute("userName", optionalUser.get().getName());
        resp.sendRedirect("/index");
    }
}
