package servlets;

import crud.UserController;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 09.11.2016.
 */

@WebServlet("/SignIn")
public class SignInServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        UserController userController = new UserController();

        User sesUser = (User) request.getSession().getAttribute("user");
        if (sesUser.getUsername() != null){
            response.sendRedirect(request.getContextPath());
            return;
        }

        User user = userController.checkUser(request.getParameter("username"), request.getParameter("password"));

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"/NewOrder");
        } else {
            request.getSession().setAttribute("SignInError", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "#SignIn");
        }
    }
}
