package servlets;

import crud.OrderController;
import entity.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/AddOrder")
public class AddOrderServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        Order order = (Order) request.getSession().getAttribute("order");
        order.setDate(java.util.Calendar.getInstance().getTime());
        OrderController orderController = new OrderController();
        orderController.updateOrder(order);

        response.sendRedirect(request.getContextPath()+"/jsp/history.jsp");
    }
}
