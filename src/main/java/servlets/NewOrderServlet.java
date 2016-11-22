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
        OrderController orderController = new OrderController();
        order = orderController.addOrder(order);

        RateController rateController = new RateController();
        Rate rate = rateController.getCurrentRate();

        //TODO rate verification

        CountryController countryController = new CountryController();
        /** CODE FOR ADD COUNTRIES TO DATABASE START HERE**/
        /**
         countryController.deleteAllCountries();
         BufferedReader readerEN = new BufferedReader(new FileReader("F:\\StorkExpress\\src\\main\\resources\\cntry_nm_EN.txt"));
         BufferedReader readerRU = new BufferedReader(new FileReader("F:\\StorkExpress\\src\\main\\resources\\cntry_nm_RU.txt"));
         BufferedReader readerCode = new BufferedReader(new FileReader("F:\\StorkExpress\\src\\main\\resources\\cntry_cd.txt"));

         String nameEN;
         String nameRU;
         String code;
         int codeInt,i=0;

         while (i<251){
         nameEN = readerEN.readLine();
         nameRU = readerRU.readLine();
         code = readerCode.readLine();
         i++;
         codeInt= Integer.parseInt(code);
         Country country = new Country(nameEN,nameRU,codeInt);
         countryController.addCountry(country);
         }
         **/
        /** CODE FOR ADD COUNTRIES TO DATABASE END HERE**/
        ArrayList<Country> countries = (ArrayList<Country>) countryController.getAllCountries();

        request.getSession().setAttribute("countries", countries);
        request.getSession().setAttribute("rate", rate);
        request.getSession().setAttribute("order", order);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
