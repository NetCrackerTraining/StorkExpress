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
        //Rate rate = new Rate();

        String description = (String) request.getParameter("description");
        String lastName = (String) request.getParameter("recipient");
//        String lastName = (String) request.getSession().getAttribute("lastName");
//        String firstName = (String) request.getSession().getAttribute("firstName");
        double weight = Double.parseDouble(request.getParameter("weight"));
        int fromCountry = Integer.parseInt(request.getParameter("fromCountry"));
        int toCountry = Integer.parseInt(request.getParameter("toCountry"));
        boolean express = Boolean.parseBoolean(request.getParameter("express"));


        //Parcel parcel = new Parcel(firstName,lastName,weight,toCountry,fromCountry,express);
        Parcel parcel = new Parcel("",lastName,weight,toCountry,fromCountry,express);
        parcel.setDescription(description);
        parcel.setCost(100);
        parcel.setDelivered(false);
        parcel.setOrderId(order.getId());
        //parcel.setRateId(rate.getId());
        parcel.setRateId(1);

        ParcelController parcelController = new ParcelController();
        parcelController.AddParcel(parcel);

        order.addParcel(parcel);

        //request.getSession().setAttribute("order", order);
        //request.getSession().setAttribute("listParcels", listParcels);

//        PrintWriter pw = null;
//        try {
//            pw = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        pw.println(listParcels);
//        pw.close();

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
