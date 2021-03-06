package servlets;

import crud.UserController;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Влад on 21.11.2016.
 */
@WebServlet("/EditUser")
public class EditUserServlet extends BaseHttpServlet {
    private void editUser(User user, HttpServletRequest request) {

        String message = "";
        Pattern passwordPattern = Pattern.compile("^[a-zA-Z0-9]{2,20}$");
        Pattern emailPattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        Pattern phonenumberPattern = Pattern.compile("(\\d){7,13}");
        Pattern namePattern = Pattern.compile("^[A-Z][a-z]{2,30}$");
        Pattern addressPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\., ]{2,100}$");


        String newEmail = request.getParameter("newEmail");
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newSecondName");
        String newPhoneNumber = request.getParameter("newPhoneNumber");
        String newAddress = request.getParameter("newAddress");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");
        if (newEmail.length() > 30 || newFirstName.length() > 30 || newLastName.length() > 30
                || newPhoneNumber.length()>20 || newAddress.length()>100
                || oldPassword.length() > 20 || newPassword.length()>20 || newPassword2.length() > 20){
            request.getSession().setAttribute("PasswordMessage", "Incorrect data");
        }
        else {
            if (!newEmail.equals(user.getEmail())){
                if (emailPattern.matcher(newEmail).matches()) {
                    user.setEmail(newEmail);
                }
                else{
                    message = message.concat("The email isn't changed\n");
                }
            }
            if (!newFirstName.equals(user.getFirstName())){
                if (namePattern.matcher(newFirstName).matches()) {
                    user.setFirstName(newFirstName);
                }
                else{
                    message = message.concat("The First Name isn't changed\n");
                }
            }

            if (!newLastName.equals(user.getLastName())){
                if (namePattern.matcher(newLastName).matches()) {
                    user.setLastName(newLastName);
                }
                else{
                    message = message.concat("The last name isn't changed\n");
                }
            }

            if (!newPhoneNumber.equals(user.getPhoneNumber())){
                if (phonenumberPattern.matcher(newPhoneNumber).matches()) {
                    user.setPhoneNumber(newPhoneNumber);
                }
                else{
                    message = message.concat("The phone number isn't changed\n");
                }
            }

            if (!newAddress.equals(user.getAddress())){
                if (addressPattern.matcher(newAddress).matches()) {
                    user.setAddress(newAddress);
                }
                else{
                    message = message.concat("The address isn't changed\n");
                }
            }

            if (!oldPassword.equals("")) {
                if (oldPassword.equals(user.getPassword()) && newPassword.equals(newPassword2)
                        && passwordPattern.matcher(newPassword).matches()) {
                    user.setPassword(newPassword);
                    request.getSession().setAttribute("PasswordMessage", "Password is changed");
                } else {
                    request.getSession().setAttribute("PasswordMessage", "The password is not changed");
                }
            }
        }
        request.getSession().setAttribute("Message", message);
    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUsername()==null){
            response.sendRedirect(request.getContextPath());
            return;
        }
        editUser(user, request);
        UserController userController = new UserController();
        userController.editUser(user);
        response.sendRedirect(request.getContextPath()+"/jsp/account.jsp");
    }
}
