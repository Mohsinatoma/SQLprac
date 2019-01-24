package dao.service;

import DBprac.dao.UserDAO;
import DBprac.model.User;
import dao.dbUtil.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.tools.sjavac.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j


public class UserDAOimplmt implements UserDAO {
	 DBConnection b; 
	
	public boolean addUser(User u) throws SQLException {
//		String str="INSERT INTO Employee_table2"+"(Id,NAME,COUNTRY,CITY,ZIPCODE,SALARY)"+" VALUES ("
//				+u.getEid()+", '"+u.getName()+"' , '"+u.getCountry()+"' , '"+u.getCity()+"' , '"+u.getZipcode()+"' ,"+u.getSalary()+")";
//				String str1="SET IDENTITY_INSERT Employee_table2 on";
//			
//				try (Statement statement = DBConnection.getConnection().createStatement()) {
//					
//						statement.executeQuery(str);
//						statement.executeQuery(str1);
//						
//						
//					}catch(Exception e) {
//						
//						log.error("Not Done "+e.getMessage());
//					}
//		
				String str="INSERT INTO Employee_table2 (NAME,COUNTRY,CITY,ZIPCODE,SALARY) VALUES ( ?, ?, ?,?,?)";
				String str1="SET IDENTITY_INSERT Employee_table2 on";
				PreparedStatement statement1 = DBConnection.getConnection().prepareStatement(str1);
				statement1.executeUpdate();
			   
				try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
	              
				
					
					statement.setString(1, u.getName());
					statement.setString(2, u.getCountry());
					statement.setString(3, u.getCity());
					statement.setString(4, u.getZipcode());
					statement.setFloat(5, u.getSalary());
					
					 statement.executeUpdate();
					
					return true;
					}catch(Exception e){
						log.error("Not Done "+e.getMessage());
					}
				return false;
						
		
	}



	public boolean updateUser(int u,String m,String n) throws SQLException {
//		Statement statement = DBConnection.getConnection().createStatement();
//		
       String str="UPDATE Employee_table2 SET NAME=?, COUNTRY=?  WHERE Id=?";
//		ResultSet rs = statement.executeQuery(str);
//		
//		
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
            
			
			statement.setString(1, m);
			statement.setString(2, n);
			statement.setInt(3, u);
			int rowsDeleted = statement.executeUpdate();

			return true;
			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		
		return false;
	
	}

	public String searchByName(String i) throws SQLException {
    
		String name=null,country=null,city=null,zipcode=null;
       String str="SELECT * FROM Employee_table2 WHERE NAME=?";
      
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
            
			statement.setString(1, i);
			 statement.execute();
		
			 ResultSet rs =statement.getResultSet();
			
			 while (rs.next()){
				     name =rs.getString("NAME");
				     country = rs.getString("COUNTRY");
				     city = rs.getString("CITY");
				    zipcode = rs.getString("ZIPCODE");
				  
				
				    return name+","+country+","+city+","+zipcode;
				   
				}

			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		
  
      return null;
		
	}



    
	public boolean deleteUser(String d) throws SQLException {
		String str="DELETE FROM Employee_table2 WHERE NAME=?";
		 
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
            
			statement.setString(1, d);
			int rowsDeleted = statement.executeUpdate();

			return true;
			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		
		return false;
	}



	




}
