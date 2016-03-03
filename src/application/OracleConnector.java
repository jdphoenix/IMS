package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleConnector {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/xe";

	static final String USER = "testuser";
	static final String PASS = "testpass";
	
	
	public void accessDB() throws SQLException {
     
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASS);
     
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(DB_URL,props);

        String sql ="select sysdate as current_day from dual";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
   
        ResultSet result = preStatement.executeQuery();
     
        while(result.next()){
            System.out.println("Current Date from Oracle : " + result.getString("current_day"));
        }
        System.out.println("done");

	}
	
	public void disconnect(Statement stmt, Connection conn) {
		if(stmt != null) 
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
