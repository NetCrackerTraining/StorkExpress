package servlets;

import clientForCityconService.merge.clientMerge;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad on 11.12.2016.
 */
@WebServlet("/Merge")
public class MergeServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        clientMerge.mergeStart();
        response.sendRedirect(request.getContextPath()+"/jsp/account.jsp");
    }
}
