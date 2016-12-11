package servlets;

import crud.Reports;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandr on 11.12.2016.
 */
@WebServlet("/OrdersOnDate")
public class OrdersOnDateServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);

        String dayString = request.getParameter("day");
        String monthString = request.getParameter("month");
        String yearString = request.getParameter("year");

        int day = 1, month= 1, year = 2016;
        boolean leap = false;

        try{
            year = Integer.parseInt(yearString);
            if(year%4==0 && year%100 !=0 || year%400==0) leap = true;
            else leap = false;
        } catch (Exception e){
            sendError(request,response, "Wrong year. Try one more time.");
            return;
        }
        if (year < 0){
            sendError(request,response, "Wrong year. Should be positive.");
            return;
        }

        try {
            month = Integer.parseInt(monthString);
        } catch (Exception e){
            sendError(request,response, "Wrong month. Try one more time.");
            return;
        }
        if (month < 1 || month > 12){
            sendError(request,response, "Wrong month. Try one more time.");
            return;
        }

        try {
            day = Integer.parseInt(dayString);
        } catch (Exception e){
            sendError(request,response, "Wrong day. Try one more time.");
            return;
        }
        if (day < 1 || day > numDaysInMonth(month,leap)){
            sendError(request,response, "Wrong day. Try one more time.");
            return;
        }


        Reports reports = new Reports();
        Integer count = reports.countOrdersOnDate(year,month,day);
        String countString;
        String[][] list = reports.ordersOnDate(year,month,day,count);
        List<OrderList> orderLists = new ArrayList<>();
        for (int i = 1; i < count+1; i++) {
            orderLists.add(new OrderList(list[0][i],list[1][i],list[2][i], list[3][i]));
        }
        try {
            countString = String.valueOf(count);
        } catch (Exception e){
            countString = "0";
        }
        request.getSession().setAttribute("ordersOnDate", orderLists);
        request.getSession().setAttribute("countOrdersOnDate", countString);
        response.sendRedirect(request.getContextPath()+"/jsp/ordersOnDateReport.jsp");
    }

    private void sendError(HttpServletRequest request, HttpServletResponse response, String error) throws IOException {
        request.getSession().setAttribute("DateError", error);
        response.sendRedirect(request.getContextPath()+"/jsp/ordersOnDateReport.jsp");
    }

    private static int numDaysInMonth(int month, boolean isLeapYear) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    public class OrderList{
        String username;
        String totalCost;
        String currency;
        String date;

        public String getUsername() {
            return username;
        }

        public String getTotalCost() {
            return totalCost;
        }

        public String getCurrency() {
            return currency;
        }

        public String getDate() {
            return date;
        }

        public OrderList(String username, String totalCost, String currency, String date) {
            this.username = username;
            this.totalCost = totalCost;
            this.currency = currency;
            this.date = date;
        }
    }
}
