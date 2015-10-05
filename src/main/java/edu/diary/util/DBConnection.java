
package edu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	public static final Logger LOG = Logger.getLogger("DBconnection");
	public static Connection conn = null;

	public static Connection openConnection() {

		try {

			Class.forName("org.postgresql.Driver");
			String databaseURL = "jdbc:postgresql://localhost:5432/courses";
			Properties properties = new Properties();
			properties.put("user", "postgres");
			properties.put("password", "Qwerty1");
			conn = DriverManager.getConnection(databaseURL, properties);
			LOG.info("Database connection established successfully");
		} catch (ClassNotFoundException e) {
			LOG.info("Error: unable to load driver class!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.info("Error: unable to set database driver! ");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			LOG.info("Cannot open datbase");

			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
				LOG.info("Connection closed");
			}
		} catch (SQLException e) {
			LOG.info("Cannot closed" + e);
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
				LOG.info("Statement closed");
			}
		} catch (SQLException e) {
			LOG.info("Cannot close" + e);
		}
	}

	public static void close(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
				LOG.info("PreparedStatement closed");
			}
		} catch (SQLException e) {
			LOG.info("Cannot close" + e);
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
				LOG.info("ResultSet closed");
			}
		} catch (SQLException e) {
			LOG.info("Cannot close" + e);
		}
	}
}
