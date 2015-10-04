package edu.diary.util;

import java.sql.Connection;
import java.sql.Statement;

public class DBPopulator {

  public DBPopulator() { }
  public static void main(String[] args) { }

  public void populateDB() {
      
    Connection conn = DBConnection.openConnection();
    SqlParser parser = new SqlParser();
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
//      String sql = "DROP TABLE IF EXISTS modules; " + "DROP TABLE IF EXISTS courses; "
//          + "DROP SEQUENCE IF EXISTS global_seq; " + "CREATE SEQUENCE global_seq START 1; "
//          + "CREATE TABLE courses " + "( "
//          + "id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'), " + "name VARCHAR NOT NULL, "
//          + "startDate DATE NOT NULL, " + "endDate   DATE NOT NULL " + "); "
//          + "CREATE TABLE modules ( " + "id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'), "
//          + "course_id     INTEGER NOT NULL, " + "name VARCHAR NOT NULL, "
//          + "isEnabled  BOOLEAN NOT NULL, " + "passed   BOOLEAN NOT NULL, "
//          + "passingScore INTEGER NOT NULL, "
//          + "FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE RESTRICT " + ");";

      stmt.executeUpdate(parser.parseSqlFile());
     DBConnection.close(stmt);
     DBConnection.closeConnection();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}
