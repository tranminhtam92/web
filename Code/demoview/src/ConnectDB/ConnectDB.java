/**
 * 
 */
/**
 * @author tao
 *
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB{

	public static Connection connection;
	public static Connection getconnectDB(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("loiconnect succesful");
			e.printStackTrace();
		}

		// Hoặc
		String url = "jdbc:sqlserver://localhost:1433;databaseName=haisan;user=sa;password=vothitam";
		String user = "sa";
		String pass = "vothitam";
		try {
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static boolean getconnectDB(String username,String password){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("loiconnect succesful");
			e.printStackTrace();
		}

		// Hoặc
		String url = "jdbc:sqlserver://localhost:1433;databaseName=haisan;user="+username+";password="+password;
		try {
			connection = DriverManager.getConnection(url);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}