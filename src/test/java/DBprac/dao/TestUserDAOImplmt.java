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
	
	
	assertTrue(u.addUser(new User(20151402,"Toma8","Bangladesh8","Dhaka8","z20168",38.568f)));

	//assertTrue(u.addUser(new User(20151407,"Toma7","Bangladesh7","Dhaka7","z20167",37.56f)));
	//assertTrue(u.addUser(new User(20151410,"Toma7","Bangladesh10","Dhaka10","z201610",47.56f)));
	}
	
	//@Test
	public void testDeleteByName() throws SQLException {
		assertTrue(u.deleteUser("Toma7"));
	}
	@Test
	public void testDeletenrml() throws SQLException {
		assertTrue(u.nrmldeleteUser("Toma8"));
	}
	@Test
	public void testUpdateById() throws SQLException {
		assertTrue(u.updateUser(1,"Tuli","Mymensingh"));
	
	}
	@Test
	public void testSearch() throws SQLException {
		
	String n=u.searchByName("Toma1");
	assertEquals("Toma1," + "Bangladesh1," + "Dhaka1," + "z20161,"+"34.56", n);
	}
	@Test
	public void testSearchbyNameAndCountry() throws SQLException {
		
	String n=u.SearchbyNameAndCountry("Toma1","bangladesh1");
	assertEquals("Toma1," + "Bangladesh1," + "Dhaka1," + "z20161,"+"34.56", n);
	}
	
	@Test
	public void testinnerjoin() throws SQLException {	
	assertTrue(u.innerjoin(1));
	}
	@Test
	public void testWildCard() throws SQLException {	
	assertTrue(u.wildCard("'?i'"));
	}
	@Test
	public void testIn() throws SQLException {	
	assertTrue(u.In());
	}
	@Test
	public void testleftjoin() throws SQLException {	
	assertTrue(u.leftjoin());
	}
	@Test
	public void testri8join() throws SQLException {	
	assertTrue(u.rightjoin());
	}
}
