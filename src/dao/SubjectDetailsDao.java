/*package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.SubjectDetails;

public class SubjectDetailsDao {

    public int setDetails(SubjectDetails details) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO subjectdetails" +
            "  (S_id, Sub_name, No_of_Modules, No_of_Hours) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
        	connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/autonomous?useSSL=false&allowPublicKeyRetrieval=true","root", "1234");
            // Step 2:Create a statement using connection object
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        	preparedStatement.setInt(1, details.getSID());
            preparedStatement.setString(2, details.getSubject());
            preparedStatement.setInt(3, details.getModule());
            preparedStatement.setInt(4, details.getHours());
            
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            //executeQuery==Select

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }finally {
        	preparedStatement.close();
        	connection.close();
        }
        return result;
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
}*/

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.SubjectDetails;

public class SubjectDetailsDao {
	
	
	
	/*
	
	readmoduledetails for particular subject
	
	*/
	
	
	
	
	
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

    public int getDetails(SubjectDetails subjectdetails) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO subjectdetails" +
            "  (S_id, Sub_name) VALUES " +
            " (?, ?);";

        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
        	connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/autonomous_timetable_system?useSSL=false&allowPublicKeyRetrieval=true","root", "abcd36");
        	
        	// Step 2:Create a statement using connection object
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        	preparedStatement.setInt(1, subjectdetails.getSID());
            preparedStatement.setString(2, subjectdetails.getSubject());
            
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            //executeQuery==Select

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }/*finally {
        	preparedStatement.close();
        	connection.close();
        }*/
        return result;
        
    }
    public int getSubID(SubjectDetails subjectdetails) throws ClassNotFoundException, SQLException{
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	int subid = 0;
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/autonomous_timetable_systyem?useSSL=false&allowPublicKeyRetrieval=true", "root", "abcd36");	
        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select Sub_id from subjectdetails where S_id = ? and Sub_name = ? ")) {
            preparedStatement.setInt(1, subjectdetails.getSID());
            preparedStatement.setString(2, subjectdetails.getSubject());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            subid = rs.getInt(1);
            	

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return subid;
    }
    
    public SubjectDetails[] readSubjectDetails(ResultSet resultSet) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	SubjectDetails sub[] = null;
    	try {
    		connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/autonomous_timetable_system?useSSL=false&allowPublicKeyRetrieval=true","root", "abcd36");
            
        	// Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
            		.executeQuery("select * from autonomous_timetablw_system.subjectdetails ");
    		int i=0;
	    	while (resultSet.next()) {
				int SID = resultSet.getInt("S_Id");
				int SubID = resultSet.getInt("Sub_ID");
				String Subject = resultSet.getString("Sub_name");
				sub[i] = new SubjectDetails();
				sub[i].setSID(SID);
				sub[i].setSubject(Subject);
				i++;
			}
	    	
    	}catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    	
		return sub;
}

// You need to close the resultSet
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {

		}
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

