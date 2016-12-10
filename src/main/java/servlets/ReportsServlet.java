package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 10.12.2016.
 */
@WebServlet("/Reports")
public class ReportsServlet extends BaseHttpServlet{
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

    }
}
