package servlets;

import crud.Reports;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
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
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 1; i < 21; i++) {
            map.put(list[0][i],list[1][i]);
        }
        request.getSession().setAttribute("topUsers", map);
        response.sendRedirect(request.getContextPath()+"/jsp/topUsersReport.jsp");

    }
}
