
package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;
import static edu.diary.util.DBConnection.conn;

public class JdbcCourseRepositoryImpl implements CourseRepository {
	private static Logger LOG = Logger.getLogger("JdbcCourseRepository"); 
	Connection conn = DBConnection.openConnection();
	PreparedStatement preparedStatement = null;
	@Override
	public Course save(Course course) {
		conn = DBConnection.openConnection();
		LOG.setLevel(Level.ALL);
		String insert = "INSERT INTO courses (name, startDate, endDate) "
				+ "VALUES (?, ?, ?)";
		try {
			
			preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.utilDateToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.utilDateToSqlDate(course.getEndDate())));
			int rows = preparedStatement.executeUpdate();
			preparedStatement.clearParameters();
			if (rows > 0) {
				LOG.info("Record is inserted into courses table. Rows =  "
						+ rows);
				System.out.println(rows);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			LOG.info("INSERT FAILED: " + e);
		} finally {
			DBConnection.closeConnection();
		}
		return course;
	}

	@Override
	public Course update(Course course) {
		conn = DBConnection.openConnection();
		String update = "UPDATE INTO courses (name, startDate, endDate) "
				+ "VALUES (?, ?, ?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2,
					(DateUtils.utilDateToSqlDate(course.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.utilDateToSqlDate(course.getEndDate())));
			int rows = preparedStatement.executeUpdate();
			preparedStatement.clearParameters();
			if (rows > 0) {
				LOG.info("Record is UPDATED into courses table" + course);
			}
			DBConnection.close(preparedStatement);
		} catch (SQLException e) {
			LOG.info("UPDATED FAILED:" + e);
		} finally {
			DBConnection.closeConnection();
		}
		return course;
	}
// ==================================================================================================================================
	@Override
	public void delete(int id) {
		String delete = "DELETE FROM courses WHERE courses.id = ?";

		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				LOG.info("record is deleted with id = " + id);
			} else {
				LOG.info("no record in database with specified id = " + id);
			}
			preparedStatement.clearParameters();
			DBConnection.close(preparedStatement);
		} catch (SQLException e) {
			LOG.info("DELETE FAILED:" + e);
		} finally {
			DBConnection.closeConnection();
		}
	}

	@Override
	public Course get(int id) {
		String getCourse = "SELECT courses.id, courses.name FROM courses "
				+ "WHERE courses.id = ?";
		Course course = new Course();
		 conn = DBConnection.openConnection();
		try {
			Connection conn = DBConnection.openConnection();
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			preparedStatement = conn.prepareStatement(getCourse);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.clearParameters();

			while (resultSet.next()) {
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
			}
			LOG.info("Record got from courses table " + course);
			DBConnection.close(resultSet);
		} catch (SQLException e) {

			LOG.info("Cannot get entry from DB " + e);
		} finally {
			DBConnection.closeConnection();
		}
		return course;
	}

	@Override
	public Set<Course> getAll() {
		Set<Course> courses = new TreeSet<>();
		conn = DBConnection.openConnection();
		String getAll = "SELECT * FROM courses";
		try {
			conn = DBConnection.openConnection();
			ResultSet resultSet = null;
			Statement statement = null;
		
			statement = conn.createStatement();
			resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				for (Course course : courses) {
					course.setId(resultSet.getInt("id"));
					course.setName(resultSet.getString("name"));
					course.setStartDate(DateUtils.sqlDatetoUtilDate(
							resultSet.getDate("startDate")).toString());
					course.setEndDate(DateUtils.sqlDatetoUtilDate(
							resultSet.getDate("endDate")).toString());
					courses.add(course);
				}
			}
			LOG.info("all courses  from courses table: " + courses);
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			LOG.info("Cannot read from DB " + e);
		} finally {
			DBConnection.closeConnection();
		}
		return courses;
	}

	@Override
	public void deleteAll() {
		String deleteAll = "DELETE FROM courses";
		
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = conn.prepareStatement(deleteAll);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				LOG.info("All record are deleted from table courses ");
			} else {
				LOG.info("DELETE FAILED ");
			}
			preparedStatement.clearParameters();
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			LOG.info("DELETE FAILED:" + e);
		} finally {
			DBConnection.closeConnection();
		}
	}
}
