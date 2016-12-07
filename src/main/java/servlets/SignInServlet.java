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
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Влад on 09.11.2016.
 */

@WebServlet("/SignIn")
public class SignInServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        String refererURI = null;
        String s = request.getHeader("Referer");
        if (s == null){
            response.sendRedirect(request.getContextPath());
            return;
        }
        try {
            refererURI = new URI(request.getHeader("Referer")).getPath();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }


        UserController userController = new UserController();

        User sesUser = (User) request.getSession().getAttribute("user");
        if (sesUser.getUsername() != null){
            response.sendRedirect(request.getContextPath());
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.length()>30 || password.length()>20){
            request.getSession().setAttribute("SignInError", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "#SignIn");
            return;
        }

        User user = userController.checkUser(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"/NewOrder");
            return;
        } else {
            request.getSession().setAttribute("SignInError", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "#SignIn");
            return;
        }
    }
}

