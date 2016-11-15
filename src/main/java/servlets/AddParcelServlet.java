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
        Rate rate = new Rate();
        List<Parcel> listParcels = order.getParcels();

        String description = (String) request.getSession().getAttribute("description");
        String lastName = (String) request.getSession().getAttribute("lastName");
        String firstName = (String) request.getSession().getAttribute("firstName");
        double weight = (Double) request.getSession().getAttribute("weight");
        int fromCountry = (Integer) request.getSession().getAttribute("fromCountry");
        int toCountry = (Integer) request.getSession().getAttribute("toCountry");
        boolean express = (Boolean) request.getSession().getAttribute("express");


        Parcel parcel = new Parcel(firstName,lastName,weight,toCountry,fromCountry,express);
        parcel.setDescription(description);
        parcel.setCost(100);
        parcel.setDelivered(false);
        parcel.setOrderId(order.getId());
        parcel.setRateId(rate.getId());

        ParcelController parcelController = new ParcelController();
        parcelController.AddParcel(parcel);

        listParcels.add(parcel);
        order.setParcels(listParcels);

        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("listParcels", listParcels);

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw.println(listParcels);
        pw.close();

        response.sendRedirect(request.getContextPath()+"/jsp/NewOrder.jsp");
    }
}
