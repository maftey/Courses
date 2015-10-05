package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class JdbcCourseRepositoryImpl implements CourseRepository {
	private static Logger logger = Logger.getLogger("JdbcCourseRepository");

	@Override
	public Course save(Course course) {

		String insert = "INSERT INTO courses (name, startDate, endDate) "
				+ "VALUES (?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.utilDateToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.utilDateToSqlDate(course.getEndDate())));
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into courses table. course =  "
						+ course);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return course;
	}

	@Override
	public Course update(Course course) {
		String update = "UPDATE INTO courses (name, startDate, endDate) "
				+ "VALUES (?, ?, ?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.utilDateToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.utilDateToSqlDate(course.getEndDate())));
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into courses table" + course);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return course;
	}

	@Override
	public void delete(int id) {
		String delete = "DELETE FROM courses WHERE courses.id = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("record is deleted with id = " + id);
			} else {
				logger.info("no record in database with specified id = " + id);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
	}

	@Override
	public Course get(int id) {
		String getCourse = "SELECT courses.id, courses.name FROM courses "
				+ "WHERE courses.id = ?";
		Course course = new Course();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.clearParameters();
			while (resultSet.next()) {
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
			}
			logger.info("Record got from courses table " + course);
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {

			logger.info("Cannot get entry from DB " + e);
		}
		return course;
	}

	@Override
	public Set<Course> getAll() {
		Set<Course> courses = new TreeSet<>();
		Course course = new Course();
		String getAll = "SELECT * FROM courses";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
				course.setStartDate(DateUtils.sqlDatetoUtilDate(
						resultSet.getDate("startDate")).toString());
				course.setEndDate(DateUtils.sqlDatetoUtilDate(
						resultSet.getDate("endDate")).toString());
				courses.add(course);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return courses;
	}

	@Override
	public void deleteAll() {
		String deleteAll = "DELETE FROM courses";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table courses ");
			} else {
				logger.info("DELETE FAILED ");
			}
			preparedStatement.clearParameters();
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
	}
}