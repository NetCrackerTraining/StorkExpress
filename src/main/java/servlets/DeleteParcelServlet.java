package servlets;

import crud.ParcelController;
import entity.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/DeleteParcel")
public class DeleteParcelServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        int parcelId = Integer.parseInt(request.getParameter("id"));

        Order order = (Order) request.getSession().getAttribute("order");
        order.deleteParcel(parcelId);

        ParcelController parcelController = new ParcelController();
        parcelController.deleteParcel(parcelId);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
//        PrintWriter pw = null;
//        try {
//            pw = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        pw.println("Ok");
//        pw.close();
    }
}
