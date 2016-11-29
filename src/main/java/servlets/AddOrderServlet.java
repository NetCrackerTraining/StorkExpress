package servlets;

import crud.OrderController;
import entity.Order;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Влад on 12.11.2016.
 */
@WebServlet("/AddOrder")
public class AddOrderServlet extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

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
        if (user.getUsername() == null || !user.isSimpleUser()){
            response.sendRedirect(request.getContextPath());
            return;
        }

        Order order = (Order) request.getSession().getAttribute("order");

        if (order == null){
            response.sendRedirect(request.getContextPath()+"/NewOrder");
            return;
        }

        if (order.getParcels().size() == 0){
            request.getSession().setAttribute("ErrorMessage", "There is no parcels");
            response.sendRedirect(request.getContextPath()+"/NewOrder");
            return;
        }

        order.setDate(java.util.Calendar.getInstance().getTime());
        OrderController orderController = new OrderController();
        orderController.addOrder(order);

        response.sendRedirect(request.getContextPath()+"/UserOrders");
    }
}
