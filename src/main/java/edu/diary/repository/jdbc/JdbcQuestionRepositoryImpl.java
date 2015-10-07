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
import edu.diary.domain.Test;
import edu.diary.repository.QuestionRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class JdbcQuestionRepositoryImpl implements QuestionRepository {

	private static Logger logger = Logger.getLogger("JdbcLessonRepository");
	private static int rows = 0;

	@Override
	public Question save(Question question) {

		String insert = "INSERT INTO questions (text, score, test_id) "
				+ "VALUES (?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, question.getText());
			preparedStatement.setInt(2, question.getScore());
			preparedStatement.setInt(3, question.getTestId());
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
		String update = "UPDATE questions "
				+ "SET  text = ?, score = ?, test_id = ?"
				+ "WHERE id = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, question.getText());
			preparedStatement.setInt(2, question.getScore());
			preparedStatement.setInt(3, question.getTestId());
			preparedStatement.setInt(3, question.getId());
			
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
	public boolean delete(Question question) {
		String delete = "DELETE FROM questions WHERE questions.id = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(delete);
			preparedStatement.setInt(1, question.getId());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("record is deleted with id = " + question.getId());
			} else {
				logger.info("no record in database with specified id = "
						+ question.getId());
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("DELETE FAILED:" + e);
		}
		return true;
	}

	public Question get(int id) {
		String getCourse = "SELECT *"
				+ "WHERE questions.id = ?";
		Question question = new Question();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				question.setId(resultSet.getInt("id"));
				question.setScore(resultSet.getInt("score"));
				question.setTestId(resultSet.getInt("test_id"));
				question.setText(resultSet.getString("text"));
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
	
	public Set<Question> getAllForTest(Test test) {
		Set<Question> questions = new TreeSet<>();
		
		String getAll = "SELECT * FROM questions WHERE test_id = ?";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getAll);
			preparedStatement.setInt(1, test.getTestId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Question question = new Question();
				question.setId(resultSet.getInt("id"));
				question.setScore(resultSet.getInt("score"));
				question.setTestId(resultSet.getInt("test_id"));
				question.setText(resultSet.getString("text"));
				
				questions.add(question);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return questions;
	}

	@Override
	public Set<Question> getAll() {
		Set<Question> questions = new TreeSet<>();
		
		String getAll = "SELECT * FROM questions";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				Question question = new Question();
				question.setId(resultSet.getInt("id"));
				question.setScore(resultSet.getInt("score"));
				question.setTestId(resultSet.getInt("test_id"));
				question.setText(resultSet.getString("text"));
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
