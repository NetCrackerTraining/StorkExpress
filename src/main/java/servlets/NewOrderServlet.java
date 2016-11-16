package servlets;

import crud.OrderController;
import entity.Order;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Влад on 12.11.2016.
 */

@WebServlet("/NewOrder")
public class NewOrderServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        User user = (User) request.getSession().getAttribute("user");

        Order order = new Order(user.getId());
        OrderController orderController = new OrderController();
        order = orderController.addOrder(order);

        request.getSession().setAttribute("order", order);

        response.sendRedirect(request.getContextPath()+"/jsp/newOrder.jsp");
    }
}
