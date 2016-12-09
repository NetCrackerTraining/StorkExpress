package crud;

import java.sql.*;

/**
 * Created by Vlad on 09.12.2016.
 */
public class Reports {
    private final String url = "jdbc:mysql://nc1.project.li:3306/nc_1";
    private final String username = "ncuser";
    private final String password = "12345nc";

    public int countOrdersOnDate(int year, int month, int day)
    {
        int count =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT count(o.date) FROM nc_1.orders o " +
                    "where YEAR(o.date)= "+year+" and MONTH(o.date)= "+month+" and DAY(o.date)= "+day+";";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String[][] ordersOnDate(int year, int month, int day, int count) {
        String[][] result = new String[4][count];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT u.username,o.totalCost,o.currency,o.date FROM nc_1.orders o "+
                    "inner join nc_1.users u on u.id=o.userId "+
                    "where YEAR(o.date)= "+year+" and MONTH(o.date)= "+month+" and DAY(o.date)= "+day+";";
            ResultSet resultSet = statement.executeQuery(sql);

            int i=0;
            while(resultSet.next()) {
                result[0][i] = resultSet.getString(1);
                result[1][i] = resultSet.getString(2);
                result[2][i] = resultSet.getString(3);
                result[3][i] = resultSet.getString(4);
                i++;
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[][] bestUsers() {
        String[][] result = new String[2][20];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "select u.username as USERID,sum(t.finCost) as COST from( " +
                    "(select o.userId,o.currency,(o.totalCost/c.currencyScale*c.currencyRate) as finCost,'BYN' as BYN from nc_1.orders o " +
                    "inner join nc_1.currency c on c.currencyAbbreviation=o.currency) t) " +
                    "inner join nc_1.users u on t.userId=u.id " +
                    "group by t.userID " +
                    "order by COST desc " +
                    "limit 20;";
            ResultSet resultSet = statement.executeQuery(sql);
            int i = 0;
            while (resultSet.next()) {
                result[0][i] = resultSet.getString(1);
                result[1][i] = resultSet.getString(2);
                i++;
            }
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}
