package clientForCityconService.merge;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Vlad on 11.12.2016.
 */
public class clientDAO {
    private static String url = "jdbc:mysql://minuon.mooo.com:3306/nc_1";
    private static String username = "ncuser";
    private static String password = "12345nc";

    public void addInUsers(String log,String pass,String email){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users (username,password,email,role) " +
                    "VALUES ('" + log + "', '" + pass + "', '" + email + "',1)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getOldUsers(String colName){
        ArrayList<String> newLog = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT "+colName+" from nc_1.users;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                newLog.add(rs.getString(1).toLowerCase());
            }
            rs.close();
            statement.close();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        return newLog;
    }

}
