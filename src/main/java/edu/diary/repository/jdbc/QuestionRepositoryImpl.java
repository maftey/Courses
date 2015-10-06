package edu.diary.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import edu.diary.domain.Question;
import edu.diary.repository.QuestionRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class QuestionRepositoryImpl implements QuestionRepository {

	private static Logger logger = Logger.getLogger("JdbcLessonRepository");
	private static int rows = 0;

	@Override
	public Question save(Question question) {

		String insert = "INSERT INTO questions (name, startdate, enddate, description, isenabled, text) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, question.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(question.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(question.getEndDate())));
			preparedStatement.setString(4, question.getDescription());
			preparedStatement.setBoolean(5, question.getEnabled());
			preparedStatement.setString(6, question.getText());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into questions table. question =  "
						+ question);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return question;
	}

	@Override
	public Question update(Question question) {
		String update = "UPDATE questions SET name = ?, startdate = ?, enddate = ?, description = ?, isenabled = ?, text = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, question.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(question.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(question.getEndDate())));
			preparedStatement.setString(4, question.getDescription());
			preparedStatement.setBoolean(5, question.getEnabled());
			preparedStatement.setString(6, question.getText());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into questions table" + question);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return question;
	}

	@Override
	public boolean delete(String name) {
		String delete = "DELETE FROM questions WHERE questions.name = ?";
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
	public Question get(String name) {
		String getCourse = "SELECT questions.name, questions.startdate, questions.enddate,"
				+ " questions.isenabled, questions.description FROM questions "
				+ "WHERE questions.name = ?";
		Question question = new Question();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				question.setName(resultSet.getString("name"));
				question.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startdate")));
				question.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				question.setEnabled(resultSet.getBoolean("isenabled"));
				question.setDescription(resultSet.getString("description"));
			}
			logger.info("Record got from questions table " + question);
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {

			logger.info("Cannot get entry from DB " + e);
		}
		return question;
	}

	@Override
	public Set<Question> getAll() {
		Set<Question> questions = new TreeSet<>();
		Question question = new Question();
		String getAll = "SELECT * FROM questions";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				question.setName(resultSet.getString("name"));
				question.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				question.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				questions.add(question);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return questions;
	}

	@Override
	public boolean deleteAll() {
		String deleteAll = "DELETE FROM questions";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table questions ");
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
