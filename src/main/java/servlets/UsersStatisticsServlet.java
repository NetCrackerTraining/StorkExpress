package servlets;

import crud.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        List<UserStatistics> list = new ArrayList<>();
        list.add(new UserStatistics("Total user count:", String.valueOf(totalUserCount)));
        list.add(new UserStatistics("Simple users count:", String.valueOf(simpleUserCount)));
        list.add(new UserStatistics("Admins count:", String.valueOf(totalUserCount - simpleUserCount)));


        request.getSession().setAttribute("usersStatistics", list);
        response.sendRedirect(request.getContextPath()+"/jsp/userStatistic.jsp");
    }
    public class UserStatistics{
        private String description;
        private String info;

        public String getDescription() {
            return description;
        }

        public String getInfo() {
            return info;
        }

        public UserStatistics(String description, String info) {
            this.description = description;
            this.info = info;
        }
    }
}
