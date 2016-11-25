package servlets;

import crud.OrderController;
import entity.Order;
import entity.User;

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
//@WebServlet("/ShowOrders")
public class ShowOrdersServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        OrderController orderController = new OrderController();
        ArrayList<Order> allOrders = orderController.getAllOrders();
        if(allOrders != null) {
            request.getSession().setAttribute("allOrders", allOrders);
            response.sendRedirect(request.getContextPath()+"/jsp/showOrders.jsp");
        }
        else {
            request.getSession().setAttribute("message", "There are no orders in the system");
            response.sendRedirect(request.getContextPath()+"/jsp/showOrders.jsp");
        }
    }
}
