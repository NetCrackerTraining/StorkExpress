package servlets;

import crud.OrderController;
import crud.ParcelController;
import crud.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Влад on 11.12.2016.
 */
@WebServlet("/OrdersStat")
public class OrdersStatisticsServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);

        OrderController orderController = new OrderController();
        Integer ordersCount = orderController.getOrdersCount();

        ParcelController parcelController = new ParcelController();
        Integer parcelsCount = parcelController.getParcelsCount();

        DecimalFormat df = new DecimalFormat("#.####");
        double average = 0.0;
        average = ((double) parcelsCount)/((double)ordersCount);


        Map<String, String> map = new HashMap<String, String>();
        map.put("Orders", String.valueOf(ordersCount));
        map.put("Parcels", String.valueOf(parcelsCount));
        map.put("Average number of parcels in order", df.format(average));

        request.getSession().setAttribute("ordersStatistics", map);
        response.sendRedirect(request.getContextPath()+"/jsp/orderStatistic.jsp");
    }
}
