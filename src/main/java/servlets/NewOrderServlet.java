package servlets;

import crud.CountryController;
import crud.CurrencyController;
import crud.OrderController;
import crud.RateController;
import entity.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Влад on 12.11.2016.
 */

@WebServlet("/NewOrder")
public class NewOrderServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        User user = (User) request.getSession().getAttribute("user");
        if (user.getUsername()==null || !user.isSimpleUser()){
            response.sendRedirect(request.getContextPath());
            return;
        }
        Order order = new Order(user.getId());
//        OrderController orderController = new OrderController();
//        order = orderController.addOrder(order);

        RateController rateController = new RateController();
        Rate rate = rateController.getCurrentRate();


        CountryController countryController = new CountryController();
        ArrayList<Country> countries = (ArrayList<Country>) countryController.getAllCountries();

        CurrencyController currencyController = new CurrencyController();
        ArrayList<Currency> currencies = (ArrayList<Currency>) currencyController.getAllCurrency();


        request.getSession().setAttribute("countries", countries);
        request.getSession().setAttribute("currencies", currencies);
        request.getSession().setAttribute("rate", rate);
        request.getSession().setAttribute("order", order);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
