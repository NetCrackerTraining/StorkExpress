package servlets;

import crud.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Влад on 10.12.2016.
 */
@WebServlet("/UsersStat")
public class UsersStatisticsServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);
        UserController userController = new UserController();
        Integer totalUserCount = userController.getAllUserCount();
        Integer simpleUserCount = userController.getSimpleUserCount();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Total user count", totalUserCount);
        map.put("Admins", totalUserCount - simpleUserCount);
        map.put("Simple users", simpleUserCount);
        request.getSession().setAttribute("usersStatistics", map);
        response.sendRedirect(request.getContextPath()+"/jsp/userStatistic.jsp");
    }
}
