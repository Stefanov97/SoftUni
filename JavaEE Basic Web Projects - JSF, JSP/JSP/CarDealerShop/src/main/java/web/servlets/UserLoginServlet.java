package web.servlets;

import domain.models.service.UserServiceModel;
import services.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {
    private final UserService userService;
    @Inject
    public UserLoginServlet(UserService userService){
        this.userService = userService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            UserServiceModel user = userService.loginUser(username, password);
            req.getSession().setAttribute("user",user.getUsername());
            resp.sendRedirect("/home");
        } catch (IllegalAccessException e) {
            resp.sendRedirect("/users/login");
        }
    }
}
