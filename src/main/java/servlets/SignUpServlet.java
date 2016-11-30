package servlets;

import crud.UserController;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Влад on 09.11.2016.
 */
@WebServlet("/SignUp")
public class SignUpServlet extends BaseHttpServlet {
    private User getUser(HttpServletRequest request, HttpServletResponse response) {
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{3,30}$");
        Pattern passwordPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{2,20}$");
        Pattern emailPattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        Pattern phonenumberPattern = Pattern.compile("(\\d){7,13}");
        Pattern namePattern = Pattern.compile("^[A-Z][a-z]{2,30}$");
        Pattern addressPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\., ]{2,100}$");




        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (username.equals("") || password.equals("") || email.equals(""))
            return null;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        if (username.length()>30 || password.length() > 20 || email.length()>50
                || firstName.length()>30 || lastName.length()>30 || phoneNumber.length()>20
                || address.length()>100){
            return null;
        }

        if (!usernamePattern.matcher(username).matches() || !passwordPattern.matcher(password).matches()
                || !emailPattern.matcher(email).matches()){
            return null;
        }

        if (!firstName.equals("") && !namePattern.matcher(firstName).matches()) { return null;}
        if (!lastName.equals("") && !namePattern.matcher(lastName).matches()) { return null;}
        if (!address.equals("") && !addressPattern.matcher(address).matches()) { return null;}
        if (!phoneNumber.equals("") && !phonenumberPattern.matcher(phoneNumber).matches()) { return null;}


        User user = new User(username, password, email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        return user;
    }

    private void sendError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("SignUpError", "Error, wrong data");
        response.sendRedirect(request.getContextPath()+"/jsp/registration.jsp");
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        String refererURI = null;
        String s = request.getHeader("Referer");
        if (s == null){
            response.sendRedirect(request.getContextPath()+"/jsp/registration.jsp");
            return;
        }
        try {
            refererURI = new URI(request.getHeader("Referer")).getPath();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (!refererURI.contains("jsp/registration.jsp")){
            response.sendRedirect(request.getContextPath()+"/jsp/registration.jsp");
            return;
        }

        User sesUser = (User) request.getSession().getAttribute("user");
        if (sesUser.getUsername() != null){
            response.sendRedirect(request.getContextPath());
            return;
        }
        User newUser = getUser(request, response);
        if (newUser != null) {
            UserController userController = new UserController();
            newUser = userController.addUser(newUser);
            if (newUser == null){
                sendError(request, response);
                return;
            }
            else{
                request.getSession().setAttribute("user", newUser);
                response.sendRedirect(request.getContextPath()+"/NewOrder");
                return;
            }
        }
        else{
            sendError(request, response);
            return;
        }
    }
}
