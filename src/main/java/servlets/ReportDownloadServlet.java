package servlets;

import crud.Reports;
import entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import utils.CreateFileReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Alexandr on 14.12.2016.
 */
@WebServlet("/Download")
public class ReportDownloadServlet extends BaseHttpServlet {
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object object = request.getSession().getAttribute("user");
        if (object == null){
            response.sendRedirect(request.getContextPath());
            return;
        }
        User user = (User) object;
        if (!user.isAdmin()){
            response.sendRedirect(request.getContextPath());
            return;
        }

        String fileName = null;
        if (!request.getParameter("report").equals("") && request.getParameter("report") != null){
            try{
                fileName = request.getParameter("report");
            } catch (Exception e){
                fileName = "report";
            }
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName +".xls");

// get the workbook from wherever
        CreateFileReport createFileReport = new CreateFileReport();
        Reports reports = new Reports();
        HSSFWorkbook wb = null;

        int day = 0, month = 0, year = 0;

        if (fileName.equals("year_report")){
            wb = createFileReport.WriteFileReport(reports.yearReport());
        }
        else if (fileName.equals("top_users")){
            wb = createFileReport.WriteFileReport(reports.bestUsers());
        } if (fileName.equals("orders_on_date")){
            if      (!request.getParameter("day").equals("") && request.getParameter("day") != null
                    && !request.getParameter("month").equals("") && request.getParameter("month") != null
                    && !request.getParameter("year").equals("") && request.getParameter("year") != null){
                try {
                    day = Integer.parseInt(request.getParameter("day"));
                    month = Integer.parseInt(request.getParameter("month"));
                    year = Integer.parseInt(request.getParameter("year"));
                } catch (Exception e){
                    request.getSession().setAttribute("DateError", "Date input error");
                    response.sendRedirect(request.getContextPath()+"/jsp/ordersOnDateReport.jsp");
                }
                Integer count = reports.countOrdersOnDate(year,month,day);
                wb = createFileReport.WriteFileReport(reports.ordersOnDate(year, month, day, count));
            }
        }

        OutputStream out = response.getOutputStream();

        try {
            if (wb != null) {
                wb.write(out);
            }
        }
        catch (IOException ioe) {
            if (!response.isCommitted()) {
                response.setContentType("text/html");
                response.sendRedirect(request.getContextPath());
            }
        }



    }
}
