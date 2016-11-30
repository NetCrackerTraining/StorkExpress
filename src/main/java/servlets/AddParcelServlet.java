package servlets;

import crud.ParcelController;
import entity.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/AddParcel")
public class AddParcelServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        Pattern descriptionPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9 ]{2,30}$");
        Pattern recipientPattern = Pattern.compile("^[A-Z][a-z]{3,29}[a-zA-Z. ]{0,29}$");


        String refererURI = null;
        String s = request.getHeader("Referer");
        if (s == null){
            response.sendRedirect(request.getContextPath()+"/NewOrder");
            return;
        }
        try {
            refererURI = new URI(request.getHeader("Referer")).getPath();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (!refererURI.contains("jsp/newOrder.jsp")){
            response.sendRedirect(request.getContextPath()+"/NewOrder");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        if(user.getUsername() == null || !user.isSimpleUser()) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        Order order = (Order) request.getSession().getAttribute("order");
        Rate rate = (Rate) request.getSession().getAttribute("rate");

        ArrayList<Country> countries = (ArrayList<Country>) request.getSession().getAttribute("countries");

        String description =  request.getParameter("description");
        String recipientInfo = request.getParameter("recipient");
        String stringWeight = request.getParameter("weight").replace(",",".");
        double weight = 0;
        try{
            weight = Double.parseDouble(stringWeight);
        } catch (Exception e){
            request.getSession().setAttribute("ParcelError", "Wrong weight");
            response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
            return;
        }
        if (weight > 100){
            request.getSession().setAttribute("ParcelError", "Wrong weight");
            response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
            return;
        }
        if (description.length()>30 || recipientInfo.length()>30
                || !descriptionPattern.matcher(description).matches()
                || !recipientPattern.matcher(recipientInfo).matches()){
            request.getSession().setAttribute("ParcelError", "Wrong input");
            response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
            return;
        }
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
        //parcel.setOrderId(order.getId());
        parcel.setRateId(rate.getId());
        parcel.setCost(rate.calculateParcelCost(parcel));
        parcel.setToCountry(toCountry);
        parcel.setFromCountry(fromCountry);

//        ParcelController parcelController = new ParcelController();
//        parcelController.AddParcel(parcel);

        order.addParcel(parcel);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
