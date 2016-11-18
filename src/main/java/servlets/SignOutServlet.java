package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 09.11.2016.
 */

@WebServlet("/SignOut")
public class SignOutServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        request.getSession().setAttribute("user", null);

        response.sendRedirect(request.getContextPath());
    }
}
