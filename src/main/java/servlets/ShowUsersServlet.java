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
import java.util.ArrayList;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/ShowUsers")
public class ShowUsersServlet extends BaseHttpServlet {

    private boolean isDigit(String digit){
        try{
            Integer.parseInt(digit);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserController userController = new UserController();
        Object obj = request.getParameter("page");
        Integer pageNumber = 1;
        Integer pageAmount = userController.getPageAmount(2);
        if (obj != null && isDigit((String) obj)){
            Integer reqPage = Integer.parseInt((String) obj);
            if (reqPage < 1){
                reqPage = 1;
            }
            if (reqPage > pageAmount){
                reqPage = pageAmount;
            }
            pageNumber = reqPage;
        }

        ArrayList<User> users = (ArrayList<User>) userController.getPageOfUsers(pageNumber, 2);

        request.setAttribute("users", users);
        request.setAttribute("pageAmount", pageAmount);
        request.setAttribute("pageNumber", pageNumber);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showUsers.jsp");
        rd.forward(request, response);
    }
}
