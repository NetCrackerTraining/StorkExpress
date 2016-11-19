package servlets;

import crud.ParcelController;
import entity.Country;
import entity.Order;
import entity.Parcel;
import entity.Rate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        ArrayList<Country> countries = (ArrayList<Country>) request.getSession().getAttribute("countries");

        String description =  request.getParameter("description");
        String recipientInfo = request.getParameter("recipient");
        double weight = Double.parseDouble(request.getParameter("weight"));
        int fromCountryId = Integer.parseInt(request.getParameter("fromCountry"));
        int toCountryId = Integer.parseInt(request.getParameter("toCountry"));
        String fromCountry = null;
        String toCountry = null;

        for (Country country: countries
                ) {
            if (country.getId() == fromCountryId){
                fromCountry = country.getCountryNameEN();
            }
            if (country.getId() == toCountryId){
                toCountry = country.getCountryNameEN();
            }
        }

        boolean express = false;
        if (request.getParameter("express") != null){
            express = true;
        }

        Parcel parcel = new Parcel(recipientInfo,weight,toCountryId,fromCountryId,express);
        parcel.setDescription(description);
        parcel.setDelivered(false);
        parcel.setOrderId(order.getId());
        parcel.setRateId(rate.getId());
        parcel.setCost(rate.calculateParcelCost(parcel));
        parcel.setToCountry(toCountry);
        parcel.setFromCountry(fromCountry);

        ParcelController parcelController = new ParcelController();
        parcelController.AddParcel(parcel);

        order.addParcel(parcel);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
