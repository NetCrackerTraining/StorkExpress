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
        User user = userController.checkUser(request.getParameter("username"), request.getParameter("password"));

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"jsp/newOrder.jsp");
        } else {
            request.getSession().setAttribute("SignInError", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "#SignIn");
        }
    }
}
