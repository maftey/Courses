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
	private static int rows = 0;

	@Override
	public Course save(Course course) {

		String insert = "INSERT INTO courses (name, startdate, enddate, isenabled, description) "
				+ "VALUES (?,?,?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(course.getEndDate())));
			preparedStatement.setBoolean(4, course.getEnabled());
			preparedStatement.setString(5, course.getDescription());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into courses table. course =  "
						+ course);
			}
			rows = 0;
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return course;
	}

	@Override
	public Course update(Course course) {
		String update = "UPDATE courses SET name = ?, startdate = ?, enddate = ?, isenabled = ?, description = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(course.getEndDate())));
			preparedStatement.setBoolean(4, course.getEnabled());
			preparedStatement.setString(5, course.getDescription());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into courses table" + course);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return course;
	}

	@Override
	public boolean delete(String name) {
		String delete = "DELETE FROM courses WHERE courses.name = ?";
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
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
		return true;

	}

	@Override
	public Course get(String name) {
		String getCourse = "SELECT courses.name, courses.startdate, courses.enddate,"
				+ " courses.isenabled, courses.description FROM courses "
				+ "WHERE courses.name = ?";
		Course course = new Course();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				course.setName(resultSet.getString("name"));
				course.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startdate")));
				course.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				course.setEnabled(resultSet.getBoolean("isenabled"));
				course.setDescription(resultSet.getString("description"));
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
				course.setName(resultSet.getString("name"));
				course.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				course.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				course.setEnabled(resultSet.getBoolean("isenabled"));
				course.setDescription(resultSet.getString("description"));
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
	public boolean deleteAll() {
		String deleteAll = "DELETE FROM courses";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table courses ");
			} else {
				logger.info("DELETE FAILED ");
			}
			preparedStatement.clearParameters();
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
		return true;
	}

	public static int getRows() {
		return rows;
	}
}