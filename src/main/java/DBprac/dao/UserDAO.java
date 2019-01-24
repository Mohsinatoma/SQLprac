package DBprac.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBprac.model.User;
import dao.dbUtil.DBConnection;

public interface UserDAO {
    public boolean addUser(User u) throws SQLException;
    public boolean deleteUser(String d) throws SQLException;
    public boolean updateUser(int u,String m,String n) throws SQLException;
    public String searchByName(String d) throws SQLException;
    
}




	 
	
