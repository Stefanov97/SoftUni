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

@WebServlet("/users/register")
public class UserRegisterServlet extends HttpServlet {
    private final UserService userService;
    @Inject
    public UserRegisterServlet(UserService userService){
        this.userService = userService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String url = "";
        if(!arePasswordsMatch(password,confirmPassword)){
           url = "/users/register";
        }
        UserServiceModel user = new UserServiceModel(username,password,email);
        try {
            if(url.isEmpty()) {
                this.userService.registerUser(user);
                url = "users/login";
            }
            resp.sendRedirect(url);
        } catch (IllegalAccessException e) {
            url = "/users/register";
            resp.sendRedirect(url);
        }

    }
    private boolean arePasswordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
