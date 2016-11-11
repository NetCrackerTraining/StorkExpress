package servlets;

import crud.UserController;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 09.11.2016.
 */
@WebServlet("/SignUp")
public class SignUpServlet extends BaseHttpServlet {
    private User getUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (username.equals("") || password.equals("") || email.equals(""))
            return null;
        User user = new User(username, password, email);
        return user;
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
    {
        response.setStatus(200);

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User newUser = getUser(request);
        if (newUser != null) {
            UserController userController = new UserController();
            newUser = userController.addUser(newUser);
            if (newUser == null){
                pw.println("No from BL");
            }
            else{
                request.getSession().setAttribute("user", newUser);
                pw.println("Ok");
                pw.println(request.getSession().getAttribute("user"));
            }
        }
        else{
            pw.println("No");
        }
    }
}
