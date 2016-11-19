package servlets;

import crud.CountryController;
import crud.OrderController;
import crud.RateController;
import entity.Country;
import entity.Order;
import entity.Rate;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Влад on 12.11.2016.
 */

@WebServlet("/NewOrder")
public class NewOrderServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        User user = (User) request.getSession().getAttribute("user");
        //TODO user verification

        Order order = new Order(user.getId());
        OrderController orderController = new OrderController();
        order = orderController.addOrder(order);

        RateController rateController = new RateController();
        Rate rate = rateController.getCurrentRate();

        //TODO rate verification

        CountryController countryController = new CountryController();
        ArrayList<Country> countries = (ArrayList<Country>) countryController.getAllCountries();

        request.getSession().setAttribute("countries", countries);
        request.getSession().setAttribute("rate", rate);
        request.getSession().setAttribute("order", order);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
