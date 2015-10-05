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
	private static Logger LOG = Logger.getLogger("JdbcCourseRepository");
	private Connection conn = null;

	@Override
	public Course save(Course course) {
		String insert = "INSERT INTO courses (name, startDate, endDate) "
					  + "VALUES (?, ?, ?)";
		String update = "UPDATE INTO courses (name, startDate, endDate) "
					  + "VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = null;
		conn = DBConnection.openConnection();
		
//		checking. if id = null then INSERT
		
		switch (course.isNew()) {

		case 0:
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
					LOG.info("Record is inserted into courses table" + course);
				}
			} catch (SQLException e) {
				LOG.info("INSERT FAILED:" + e);

			} finally {
				DBConnection.close(preparedStatement);
				DBConnection.closeConnection();
			}

			break;

		// checking. if id!=null then UPDATE
		case 1:
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
					LOG.info("Record is UPDATED into courses table" + course);
				}
			} catch (SQLException e) {
				LOG.info("UPDATED FAILED:" + e);

			} finally {
				DBConnection.close(preparedStatement);
				DBConnection.closeConnection();
			}

			break;
		}
		return course;
	}

	@Override
	public void delete(int id) {
		String delete = "DELETE FROM courses WHERE courses.id = ?";
		PreparedStatement preparedStatement = null;
		conn = DBConnection.openConnection();
		try {
			conn = DBConnection.openConnection();
			preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				LOG.info("record is deleted with id = " + id);
			} else {
				LOG.info("no record in database with specified id = " + id);
			}
			preparedStatement.clearParameters();
		} catch (SQLException e) {
			LOG.info("DELETE FAILED:" + e);
		} finally {
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		}
	}

	@Override
	public Course get(int id) {
		String getCourse = "SELECT courses.id, courses.name FROM courses "
						 + "WHERE courses.id = ?";
		PreparedStatement preparedStatement = null;
		conn = DBConnection.openConnection();
		Course course = new Course();
		ResultSet resultSet = null;
		Statement statement = null;
		conn = DBConnection.openConnection();
		try {
			preparedStatement = conn.prepareStatement(getCourse);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.clearParameters();

			while (resultSet.next()) {
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
			}
			LOG.info("Record got from courses table " + course);
		} catch (SQLException e) {
			LOG.info("Cannot read from DB " + e);
		} finally {
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		}
		return course;
	}

	@Override
	public Set<Course> getAll() {
		Set<Course> courses = new TreeSet<>();
		conn = DBConnection.openConnection();
		String getAll = "SELECT * FROM courses";
		ResultSet resultSet = null;
		Statement statement = null;
		conn = DBConnection.openConnection();
		try {
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
		} catch (SQLException e) {
			LOG.info("Cannot read from DB " + e);
		} finally {
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		}
		return courses;
	}

	@Override
	public void deleteAll() {
		String deleteAll = "DELETE FROM courses";
		PreparedStatement preparedStatement = null;
		conn = DBConnection.openConnection();
		try {
			preparedStatement = conn.prepareStatement(deleteAll);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				LOG.info("All record are deleted from table courses ");
			} else {
				LOG.info("DELETE FAILED ");
			}
			preparedStatement.clearParameters();
		} catch (SQLException e) {
			LOG.info("DELETE FAILED:" + e);
		} finally {
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		}
	}
}
