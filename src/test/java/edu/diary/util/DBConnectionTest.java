package edu.diary.util;

import static org.testng.AssertJUnit.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DBConnectionTest {
 
  
  @AfterTest
  
  
  @Test
  public void openConnectionTest() throws SQLException {
    Connection conn = null;
    conn = DBConnection.openConnection();
    assertEquals(conn == null, true);
    conn.close();
  }
 
  @Test
  public void closeStatementTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void closeResultSetTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void closeConnectionTest() throws SQLException {
   Connection conn = DBConnection.openConnection();
   conn.close();
   assertEquals(conn == null, true);
  }
}
