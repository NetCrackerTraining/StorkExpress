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
    protected void process(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);

        User user = (User) request.getSession().getAttribute("user");

        Order order = new Order(user.getId());
        OrderController orderController = new OrderController();
        orderController.addOrder(order);

        request.getSession().setAttribute("order", order);

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw.println(order.getId());
        pw.println(order.getUserId());
        pw.close();
    }
}
