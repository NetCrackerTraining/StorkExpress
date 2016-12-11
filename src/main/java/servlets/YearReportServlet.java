package servlets;

import crud.Reports;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Alexandr on 11.12.2016.
 */
@WebServlet("/YearReport")
public class YearReportServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setStatus(200);
        Reports reports = new Reports();
        String[][] s = reports.yearReport();
        List<YearReport> list = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            list.add(new YearReport(s[0][i],s[1][i],s[2][i]));
        }
        request.getSession().setAttribute("yearReport", list);
        response.sendRedirect(request.getContextPath()+"/jsp/yearReport.jsp");
    }
    public class YearReport{
        private String month;
        private String orders;
        private String profit;

        public YearReport(String month, String orders, String profit) {
            this.month = month;
            this.orders = orders;
            this.profit = profit;
        }

        public String getMonth() {
            return month;
        }

        public String getOrders() {

            return orders;
        }

        public String getProfit() {
            return profit;
        }
    }
}
