package servlets;

import crud.Reports;
import utils.CreateFileReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandr on 11.12.2016.
 */
@WebServlet("/TopUsers")
public class TopUsersServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);
        Reports reports = new Reports();
        String[][] list = reports.bestUsers();

        List<TopUsers> topUsers = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            topUsers.add(new TopUsers(list[0][i],list[1][i]));
        }


        request.getSession().setAttribute("topUsers", topUsers);
        response.sendRedirect(request.getContextPath()+"/jsp/topUsersReport.jsp");

    }
    public class TopUsers{
        private String username;
        private String profit;

        public String getUsername() {
            return username;
        }

        public String getProfit() {
            return profit;
        }

        public TopUsers(String username, String profit) {

            this.username = username;
            this.profit = profit;
        }
    }

}
