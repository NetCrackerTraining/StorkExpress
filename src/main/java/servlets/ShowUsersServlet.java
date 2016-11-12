package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/ShowUsers")
public class ShowUsersServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw.println("Ok");
        pw.close();
    }
}
