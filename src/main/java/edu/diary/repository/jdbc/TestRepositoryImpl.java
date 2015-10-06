package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import edu.diary.domain.Test;
import edu.diary.repository.TestRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class TestRepositoryImpl implements TestRepository {

	private static Logger logger = Logger.getLogger("JdbcLessonRepository");
	private static int rows = 0;

	@Override
	public Test save(Test test) {

		String insert = "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
				+ "VALUES (?,?,?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, test.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(test.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(test.getEndDate())));
			preparedStatement.setBoolean(4, test.getEnabled());
			preparedStatement.setInt(5, test.getPassedScore());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into tests table. test =  "
						+ test);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return test;
	}

	@Override
	public Test update(Test test) {
		String update = "UPDATE tests SET name = ?, startdate = ?, enddate = ?, isenabled = ?, passedscore = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, test.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(test.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(test.getEndDate())));
			preparedStatement.setBoolean(4, test.getEnabled());
			preparedStatement.setInt(5, test.getPassedScore());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into tests table" + test);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return test;
	}

	@Override
	public boolean delete(String name) {
		String delete = "DELETE FROM tests WHERE tests.name = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setString(1, name);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("record is deleted with name = " + name);
			} else {
				logger.info("no record in database with specified name = "
						+ name);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
		return true;
	}

	@Override
	public Test get(String name) {
		String getCourse = "SELECT tests.name, tests.startdate, tests.enddate,"
				+ " tests.isenabled, tests.description FROM tests "
				+ "WHERE tests.name = ?";
		Test test = new Test();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				test.setName(resultSet.getString("name"));
				test.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startdate")));
				test.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				test.setEnabled(resultSet.getBoolean("isenabled"));
				test.setDescription(resultSet.getString("description"));
			}
			logger.info("Record got from tests table " + test);
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {

			logger.info("Cannot get entry from DB " + e);
		}
		return test;
	}

	@Override
	public Set<Test> getAll() {
		Set<Test> tests = new TreeSet<>();
		
		String getAll = "SELECT * FROM tests";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				Test test = new Test();
				test.setName(resultSet.getString("name"));
				test.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				test.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				tests.add(test);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return tests;
	}

	@Override
	public boolean deleteAll() {
		String deleteAll = "DELETE FROM tests";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table tests ");
			} else {
				logger.info("DELETE FAILED ");
			}

			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
		return true;
	}

}
