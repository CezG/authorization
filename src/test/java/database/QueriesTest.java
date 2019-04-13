package database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.mockito.Mockito;

public class QueriesTest extends Mockito{


	@Test
	public void testCheckLogin_correctAdminData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertTrue( query.checkLogin("admin", "admin") );
	}
	
	@Test
	public void testCheckLogin_correctUserData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertTrue( query.checkLogin("user", "user") );
	}
	
	@Test
	public void testCheckLogin_correctPremiumUserData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertTrue( query.checkLogin("premium", "premium") );
	}
	
	@Test
	public void testCheckLogin_falseAdminData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertFalse( query.checkLogin("admin", "user") );
	}
	
	@Test
	public void testCheckLogin_falseUserData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertFalse( query.checkLogin("user", "zzs") );
	}
	
	@Test
	public void testCheckLogin_falsePremiumData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertFalse( query.checkLogin("premium", "pr") );
	}
	
	@Test
	public void testCheckLogin_falseData() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();		
		assertFalse( query.checkLogin("prem", "pr") );
	}

	@Test
	public void testCheckUserRole_adminShouldBeTrue() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertEquals("admin", query.checkUserRole("admin", "admin") );
	}

	@Test
	public void testCheckUserRole_userShouldBeTrue() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertEquals("user", query.checkUserRole("user", "user") );
	}
	
	@Test
	public void testCheckUserRole_premiumShouldBeTrue() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertEquals("premiumUser", query.checkUserRole("premium", "premium") );
	}
	
	@Test
	public void testCheckUserRole_adminShouldBeFalse() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertNotEquals("admin", query.checkUserRole("admin1", "admin") );
	}

	@Test
	public void testCheckUserRole_userShouldBeFalse() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertNotEquals("user", query.checkUserRole("user", "user1") );
	}
	
	@Test
	public void testCheckUserRole_premiumShouldBeFalse() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertNotEquals("premiumUser", query.checkUserRole("premium2", "premium") );
	}
	
	
	
	@Test
	public void testCheckUserEmail_adminShouldBeTrue() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertEquals("admin@admin.com", query.checkUserEmail("admin", "admin") );
	}
	
	@Test
	public void testCheckUserEmail_userShouldBeTrue() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertEquals("user@user.com", query.checkUserEmail("user", "user") );
	}
	
	@Test
	public void testCheckUserEmail_premiumUserShouldBeTrue() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertEquals("premium@premium.com", query.checkUserEmail("premium", "premium") );
	}
	
	@Test
	public void testCheckUserEmail_adminShouldBeFalse() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertNotEquals("admin@admin.com", query.checkUserEmail("aaadmin", "admin") );
	}
	
	@Test
	public void testCheckUserEmail_userShouldBeFalse() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertNotEquals("user@user.com", query.checkUserEmail("uuuuser", "user") );
	}
	
	@Test
	public void testCheckUserEmail_premiumUserShouldBeFalse() throws SQLException, ClassNotFoundException {
		Queries query = new Queries();	
		assertNotEquals("premium@premium.com", query.checkUserEmail("prbemium", "premium") );
	}
	
	

	@Test
	public void testCheckIsTheUserAlreadyInDatabase_shouldBeTrue() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertTrue( query.checkIsTheUserAlreadyInDatabase("admin") );
	}
	
	@Test
	public void testCheckIsTheUserAlreadyInDatabase_shouldBeFalse() throws ClassNotFoundException, SQLException {
		Queries query = new Queries();	
		assertFalse( query.checkIsTheUserAlreadyInDatabase("Centurion") );
	}


}
