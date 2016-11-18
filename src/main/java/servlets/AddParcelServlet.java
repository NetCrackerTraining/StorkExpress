package servlets;

import crud.ParcelController;
import entity.Order;
import entity.Parcel;
import entity.Rate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/AddParcel")
public class AddParcelServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        Order order = (Order) request.getSession().getAttribute("order");
        Rate rate = (Rate) request.getSession().getAttribute("rate");

        String description =  request.getParameter("description");
        String recipientInfo = request.getParameter("recipient");
        double weight = Double.parseDouble(request.getParameter("weight"));
        int fromCountry = Integer.parseInt(request.getParameter("fromCountry"));
        int toCountry = Integer.parseInt(request.getParameter("toCountry"));
        boolean express = false;
        if (request.getParameter("express") != null){
            express = true;
        }

        Parcel parcel = new Parcel(recipientInfo,weight,toCountry,fromCountry,express);
        parcel.setDescription(description);
        parcel.setDelivered(false);
        parcel.setOrderId(order.getId());
        parcel.setRateId(rate.getId());
        parcel.setCost(rate.calculateParcelCost(parcel));

        ParcelController parcelController = new ParcelController();
        parcelController.AddParcel(parcel);

        order.addParcel(parcel);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
