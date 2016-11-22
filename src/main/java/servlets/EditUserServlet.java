package servlets;

import crud.UserController;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 21.11.2016.
 */
@WebServlet("/EditUser")
public class EditUserServlet extends BaseHttpServlet {
    private void editUser(User user, HttpServletRequest request) {
        String newEmail = request.getParameter("newEmail");
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newSecondName");
        String newPhoneNumber = request.getParameter("newPhoneNumber");
        String newAddress = request.getParameter("newAddress");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");
        if (!newEmail.equals("")){
            user.setEmail(newEmail);
        }
        if (!newFirstName.equals("")){
            user.setFirstName(newFirstName);
        }
        if (!newLastName.equals("")){
            user.setLastName(newLastName);
        }
        if(!newPhoneNumber.equals("")){
            user.setPhoneNumber(newPhoneNumber);
        }
        if (!newAddress.equals("")){
            user.setAddress(newAddress);
        }
        if (!oldPassword.equals("")){
            if (oldPassword.equals(user.getPassword()) && newPassword.equals(newPassword2)){
                user.setPassword(newPassword);
                request.getSession().setAttribute("PasswordMessage", "Password is changed");
            }
            else{
                request.getSession().setAttribute("PasswordMessage", "The password is not changed");
            }
        }

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
