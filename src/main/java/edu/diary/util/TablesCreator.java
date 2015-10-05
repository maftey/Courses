package edu.diary.util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;

public class TablesCreator {
	private static Logger LOG = Logger.getLogger("DBCreator");

	public void createDB() {

		try {
			 Connection conn = DBConnection.openConnection();
					String sql = "DROP TABLE IF EXISTS modules; "
					+ "DROP TABLE IF EXISTS courses; "
					+ "DROP SEQUENCE IF EXISTS global_seq; "
					+ "CREATE SEQUENCE global_seq START 1; "
					+ "CREATE TABLE courses "
					+ "( "
					+ "id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'), "
					+ "name VARCHAR NOT NULL, "
					+ "startDate DATE NOT NULL, "
					+ "endDate   DATE NOT NULL "
					+ "); "
					+ "CREATE TABLE modules ( "
					+ "id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'), "
					+ "course_id     INTEGER NOT NULL, "
					+ "name VARCHAR NOT NULL, "
					+ "isEnabled  BOOLEAN NOT NULL, "
					+ "passed   BOOLEAN NOT NULL, "
					+ "passingScore INTEGER NOT NULL, "
					+ "FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE RESTRICT"
					+ ");";
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows);
			if (rows > 0) {
				LOG.info("Tables created successfully");
			}
			DBConnection.close(stmt);
			DBConnection.closeConnection();
		} catch (Exception e) {
			LOG.info("Tables didn't created! " + e);
		}
	}
}
