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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


        List<OrderStatistic> list = new ArrayList<>();
        list.add(new OrderStatistic("Orders count:", String.valueOf(ordersCount)));
        list.add(new OrderStatistic("Parcels count:", String.valueOf(parcelsCount)));
        list.add(new OrderStatistic("Average number of parcels in order:",df.format(average)));

        request.getSession().setAttribute("ordersStatistics", list);
        response.sendRedirect(request.getContextPath()+"/jsp/orderStatistic.jsp");
    }

    public class OrderStatistic{
        private String description;
        private String info;

        public String getDescription() {
            return description;
        }

        public String getInfo() {
            return info;
        }

        public OrderStatistic(String description, String info) {
            this.description = description;
            this.info = info;
        }
    }
}
