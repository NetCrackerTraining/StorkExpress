package clientForCityconService.merge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vlad on 11.12.2016.
 */
public class clientDAO {
    private static String url = "jdbc:mysql://nc1.project.li:3306/nc_1";
    private static String username = "ncuser";
    private static String password = "12345nc";

    public void addInSource(String log,String pass,String email){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO sourceTable " +
                    "VALUES ('" + log + "', '" + pass + "', '" + email + "')";
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

    public void mergeWithTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users(username,password,email,role) " +
                    "select log,pass,email,1 from sourceTable "+
                    "where ((log not in (select u.username from nc_1.users u)) and (email not in (select u.email from nc_1.users u)));";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void deleteSource(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            Statement statement = connection.createStatement();
            String sql = "delete from nc_1.sourceTable where sourceTable.log!='-1';";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

}
