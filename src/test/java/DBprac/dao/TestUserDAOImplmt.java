package DBprac.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import DBprac.model.User;
import dao.service.UserDAOimplmt;

import org.junit.Before;
import org.junit.Test;

public class TestUserDAOImplmt {
	UserDAOimplmt u=new UserDAOimplmt ();
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void addtest() throws SQLException {
	
	assertTrue(u.addUser(new User(20151401,"Toma2","Bangladesh2","Dhaka2","z20162",34.56f)));
		
	}
	
	@Test
	public void testDeleteByName() throws SQLException {
		assertTrue(u.deleteUser("Toma2"));
	}
	@Test
	public void testUpdateById() throws SQLException {
		assertTrue(u.updateUser(20151403,"Tuli","Mymensingh"));
	
	}
	@Test
	public void testSearch() throws SQLException {
		
	String n=u.searchByName("Toma1");
	assertEquals("Toma1," + "Bangladesh1," + "Dhaka6," + "z20161", n);
	}
}
