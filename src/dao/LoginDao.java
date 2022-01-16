package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class LoginDao {

    public boolean validate(Login login) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/autonomous?useSSL=false&allowPublicKeyRetrieval=true", "root", "1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where Email_id = ? and Password = ? ")) {
            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    public int getSID(Login login) throws ClassNotFoundException {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	int sid = 0;
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/autonomous?useSSL=false&allowPublicKeyRetrieval=true", "root", "1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select S_id from login where Email_id = ? and Password = ? ")) {
            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            sid = rs.getInt(1);
 

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return sid;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}