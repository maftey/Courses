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

	public static synchronized Connection openConnection() {

		try {

			Class.forName("org.postgresql.Driver");
			String databaseURL = "jdbc:postgresql://localhost:5432/courses";
			Properties properties = new Properties();
			properties.put("user", "user");
			properties.put("password", "user");

			if (conn == null) {
				conn = DriverManager.getConnection(databaseURL, properties);
				LOG.info("Database connection established successfully");
				return conn;
			}
		} catch (ClassNotFoundException e) {
			LOG.info("Error: unable to load driver class!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.info("Error: unable to set database driver! ");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			LOG.info("Cannot open datbase");
			
			e.printStackTrace();
		}
		System.exit(0);
		return null;
	}

	public static synchronized void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void close(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
