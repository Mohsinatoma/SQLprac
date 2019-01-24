package dao.dbUtil;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBOperation {
//	public static void main(String[] args) throws SQLException {
//		String connectionUrl = "jdbc:sqlserver://vNTDACWSSQLD002:1433;\"\r\n" + 
//				"						+ \"databaseName=DEV_TEST;user=dev_test_dbo;password=dev_test_dbo123";
//		Connection connection = DriverManager.getConnection(connectionUrl);
//		// Create a Table 
//		
//		 String sql = "CREATE TABLE Employee_table2" +
//                 "(Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY, " +
//                 "NAME NVARCHAR(50) NOT NULL, " + 
//                 "COUNTRY NVARCHAR(50) NOT NULL, " + 
//                 "CITY NVARCHAR(50) NOT NULL, " +	                   
//                 "ZIPCODE NVARCHAR(50) NOT NULL, " + 
//                 "SALARY Float NOT NULL);"; 
//		
//
/*//		try (Statement statement = connection.createStatement()) {
//			statement.executeUpdate(sql);
//			System.out.println("Done.");
//		}catch(Exception e) {
//			System.out.println("Not Done.");
//		}
*/

//	}
}
