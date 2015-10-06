package edu.diary.util;

import static org.testng.AssertJUnit.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DBConnectionTest {

	@Test
	public void openConnectionTest() throws SQLException {
		
		Connection conn = DBConnection.openConnection();
		assertEquals(conn != null, true);
		conn.close();
	}

	 @Test
	 public void closeStatementTest() throws SQLException {
		 Connection conn =null;
		 Statement statement = conn.createStatement();
		 DBConnection.close(statement);
		 assertEquals(statement == null, statement);
		 
		 
	 throw new RuntimeException("Test not implemented");
	 }
	//
	// @Test
	// public void closeResultSetTest() {
	// throw new RuntimeException("Test not implemented");
	// }

	@Test
	public void closeConnectionTest() throws SQLException {
		Connection conn = DBConnection.openConnection();
		DBConnection.closeConnection();
		assertEquals(conn == null, true);
	}
}
