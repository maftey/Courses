package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import edu.diary.domain.Lesson;
import edu.diary.domain.Module;
import edu.diary.repository.LessonRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class JdbcLessonRepositoryImpl implements LessonRepository {

	private static Logger logger = Logger.getLogger("JdbcLessonRepository");
	private static int rows = 0;

	@Override
	public Lesson save(Lesson lesson) {

		String insert = "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, test_id) "
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, lesson.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(lesson.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(lesson.getEndDate())));
			preparedStatement.setString(4, lesson.getDescription());
			preparedStatement.setBoolean(5, lesson.getEnabled());
			preparedStatement.setString(6, lesson.getText());
			
			if(lesson.getTestId() == 0) 
				preparedStatement.setNull(7, java.sql.Types.INTEGER);
			else
				preparedStatement.setInt(7, lesson.getTestId());
			
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into lessons table. lesson =  "
						+ lesson);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return lesson;
	}

	@Override
	public Lesson update(Lesson lesson) {
		String update = "UPDATE lessons "
				+ "SET name = ?, startdate = ?, enddate = ?, description = ?, isenabled = ?, text = ?, test_id = ?, module_id = ?"
				+ "WHERE id = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, lesson.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(lesson.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(lesson.getEndDate())));
			preparedStatement.setString(4, lesson.getDescription());
			preparedStatement.setBoolean(5, lesson.getEnabled());
			preparedStatement.setString(6, lesson.getText());
			
			if(lesson.getTestId() == 0) 
				preparedStatement.setNull(7, java.sql.Types.INTEGER);
			else
				preparedStatement.setInt(7, lesson.getTestId());
			
			preparedStatement.setInt(8, lesson.getModuleId());
			preparedStatement.setInt(9, lesson.getId());
			
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into lessons table" + lesson);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return lesson;
	}

	@Override
	public boolean delete(String name) {
		String delete = "DELETE FROM lessons WHERE lessons.name = ?";
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
	public Lesson get(String name) {
		String getCourse = "SELECT lessons.name, lessons.startdate, lessons.enddate,"
				+ " lessons.isenabled, lessons.description FROM lessons "
				+ "WHERE lessons.name = ?";
		Lesson lesson = new Lesson();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next() ;
			lesson.setId(resultSet.getInt("id"));
			lesson.setName(resultSet.getString("name"));
			lesson.setStartDate(DateUtils.sqlDateToCalendar(resultSet
				.getDate("startdate")));
			lesson.setEndDate(DateUtils.sqlDateToCalendar(resultSet
				.getDate("endDate")));
			lesson.setEnabled(resultSet.getBoolean("isenabled"));
			lesson.setDescription(resultSet.getString("description"));
			
			logger.info("Record got from lessons table " + lesson);
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {

			logger.info("Cannot get entry from DB " + e);
		}
		return lesson;
	}

	@Override
	public Set<Lesson> getAll() {
		Set<Lesson> lessons = new TreeSet<>();
		
		String getAll = "SELECT * FROM lessons";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				Lesson lesson = new Lesson();
				lesson.setId(resultSet.getInt("id"));
				lesson.setName(resultSet.getString("name"));
				lesson.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				lesson.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				lessons.add(lesson);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return lessons;
	}
	
	public Set<Lesson> getAllForModule(Module module) {
		Set<Lesson> lessons = new TreeSet<>();
		
		String getAll = "SELECT * FROM lessons WHERE module_id = ?";
		try {
			
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getAll);
			preparedStatement.setInt(1, module.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Lesson lesson = new Lesson();
				lesson.setName(resultSet.getString("name"));
				lesson.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				lesson.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				lessons.add(lesson);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return lessons;
	}

	@Override
	public boolean deleteAll() {
		String deleteAll = "DELETE FROM lessons";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table lessons ");
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
