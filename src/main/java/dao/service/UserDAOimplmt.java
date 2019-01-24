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
		float salary;
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
				    salary=rs.getFloat("SALARY");
				    salary=Math.abs(salary);
				  
				    return name+","+country+","+city+","+zipcode+","+salary;
				   
				}

			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		
  
      return null;
		
	}



    
	public boolean deleteUser(String d) throws SQLException {
	    
		String str="SELECT * FROM Employee_table2 WHERE NAME=?";
		String str2="SELECT * FROM Employee_table2";
		String str1="DELETE FROM Employee_table2 WHERE NAME=?";
		String name=null,country=null,city=null,zipcode=null;
		String name1=null,country1=null,city1=null,zipcode1=null;
		float salary = 0;
		
		PreparedStatement statement = DBConnection.getConnection().prepareStatement(str) ;
		statement.setString(1, d);
		statement.execute();
		ResultSet rs =statement.getResultSet();
		
		while(rs.next())
		{ 
			name =rs.getString("NAME");
		     country = rs.getString("COUNTRY");
		     city = rs.getString("CITY");
		     zipcode = rs.getString("ZIPCODE");
		     salary=rs.getFloat("SALARY");
		     salary=Math.abs(salary);
		    
		 }
			
		
		     
			    
			   try (PreparedStatement statement3 = DBConnection.getConnection().prepareStatement(str2)){
				 
				   statement3.setString(1, d);
					statement3.execute();
					ResultSet rs1 =statement3.getResultSet();
					 System.out.println(rs1);
				 while (rs1.next()) {
				
					  name1 =rs1.getString("NAME");
					   country1 = rs1.getString("COUNTRY");
					   city1 = rs1.getString("CITY");
					   zipcode1 = rs1.getString("ZIPCODE");
					   System.out.println(name1);
					   if(name1.equals(name) && country1.equals(country)&& city1.equals(city) && zipcode1.equals(zipcode)) {
						   PreparedStatement statement1 = DBConnection.getConnection().prepareStatement(str1) ;
							statement1.setString(1, d);
					       return statement1.execute();
				 }
			   }
			    
			   }catch(Exception e){
					log.error("Not Done "+e.getMessage());
				}	
			
		return false;
	}



	public String SearchbyNameAndCountry(String n, String c) {
		
		String name=null,country=null,city=null,zipcode=null;
		float salary;
       String str="SELECT * FROM Employee_table2 WHERE NAME=? AND COUNTRY=?";
      
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
            
			statement.setString(1, n);
			statement.setString(2, c);
			 statement.execute();
		
			 ResultSet rs =statement.getResultSet();
			
			 while (rs.next()){
				 
				     name =rs.getString("NAME");
				     country = rs.getString("COUNTRY");
				     city = rs.getString("CITY");
				     zipcode = rs.getString("ZIPCODE");
				     salary=rs.getFloat("SALARY");
				     salary=Math.abs(salary);
				  
				    return name+","+country+","+city+","+zipcode+","+salary;
				   
				}

			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		return null;
	}



	
    
	public boolean innerjoin(int i) throws SQLException {
		

		String str="SELECT Employee_table2.NAME, Employee_table2.COUNTRY,Employee_table2.CITY,Employee_table2.SALARY FROM Employee_table2 INNER JOIN Employee_project ON Employee_table2.id=Employee_project.id where Employee_table2.id=?";

		
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
			statement.setInt(1, i);
	
			
			boolean n= statement.execute();
		
		
             return true;
			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
	
		return false;
	}
	public boolean nrmldeleteUser(String d) throws SQLException {
		String str="DELETE FROM Employee_table2 WHERE NAME=?";
		int rowsDeleted=0;
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
            
			statement.setString(1, d);
			 rowsDeleted = statement.executeUpdate();

			
			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		if(rowsDeleted >0) return true;
		
		return false;
	}



	public boolean wildCard(String s) {

       String str="SELECT * FROM Employee_table2 WHERE NAME like ?";
      
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
			
			statement.setString(1, s);
			 statement.execute();
		 return true;

			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
		
		return false;
	}



	public boolean In() {
	String str="SELECT * FROM Employee_table2  WHERE Id IN (SELECT Id FROM Employee_project)";
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
	  boolean n=statement.execute();
	  return n;

		}catch(Exception e){
			log.error("Not Done "+e.getMessage());
		}
		
		return false;
	}
	

	public boolean leftjoin() {
	String str="SELECT * FROM Employee_table2 LEFT JOIN Employee_project ON  Employee_table2.Id=Employee_project.Id;";
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
	  boolean n=statement.execute();
	  return n;

		}catch(Exception e){
			log.error("Not Done "+e.getMessage());
		}
		
		return false;
	}



	public boolean rightjoin() {
		String str="SELECT * FROM Employee_table2 RIGHT JOIN Employee_project ON  Employee_table2.Id=Employee_project.Id;";
		try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(str)) {
		  boolean n=statement.execute();
		  return n;

			}catch(Exception e){
				log.error("Not Done "+e.getMessage());
			}
			
			return false;
	}
	
	

}
