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
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setAddress(request.getParameter("address"));
        return user;
    }

    private void sendError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("SignUpError", "Error, choose another username");
        response.sendRedirect(request.getContextPath()+"/jsp/registration.jsp");
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                sendError(request, response);
            }
            else{
                request.getSession().setAttribute("user", newUser);
                response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
            }
        }
        else{
            sendError(request, response);
        }
    }
}
