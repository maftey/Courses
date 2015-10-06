package edu.diary.repository.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import edu.diary.domain.Module;
import edu.diary.repository.ModuleRepository;
import edu.diary.util.DBConnection;
import edu.diary.util.DateUtils;

public class JdbcModuleRepositoryImpl implements ModuleRepository {

	private static Logger logger = Logger.getLogger("JdbcModuleRepository");
	private static int rows = 0;

	@Override
	public Module save(Module module) {

		String insert = "INSERT INTO modules (name, startdate, enddate, description, isenabled) "
				+ "VALUES (?,?,?,?,?)";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, module.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(module.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(module.getEndDate())));
			preparedStatement.setString(4, module.getDescription());
			preparedStatement.setBoolean(5, module.getEnabled());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is inserted into modules table. module =  "
						+ module);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("INSERT FAILED: " + e);
		}
		return module;
	}

	@Override
	public Module update(Module module) {
		String update = "UPDATE modules SET name = ?, startdate = ?, enddate = ?, description = ?, isenabled = ?";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, module.getName());
			preparedStatement.setDate(2,
					(DateUtils.calendarToSqlDate(module.getStartDate())));
			preparedStatement.setDate(3,
					(DateUtils.calendarToSqlDate(module.getEndDate())));
			preparedStatement.setString(4, module.getDescription());
			preparedStatement.setBoolean(5, module.getEnabled());
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("Record is UPDATED into modules table" + module);
			}
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
			rows = 0;
		} catch (SQLException e) {
			logger.info("UPDATED FAILED:" + e);
		}
		return module;
	}

	@Override
	public boolean delete(String name) {
		String delete = "DELETE FROM modules WHERE modules.name = ?";
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
	public Module get(String name) {
		String getCourse = "SELECT modules.name, modules.startdate, modules.enddate,"
				+ " modules.isenabled, modules.description FROM modules "
				+ "WHERE modules.name = ?";
		Module module = new Module();
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(getCourse);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				module.setName(resultSet.getString("name"));
				module.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startdate")));
				module.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				module.setEnabled(resultSet.getBoolean("isenabled"));
				module.setDescription(resultSet.getString("description"));
			}
			logger.info("Record got from modules table " + module);
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.closeConnection();
		} catch (SQLException e) {

			logger.info("Cannot get entry from DB " + e);
		}
		return module;
	}

	@Override
	public Set<Module> getAll() {
		Set<Module> modules = new TreeSet<>();
		Module module = new Module();
		String getAll = "SELECT * FROM modules";
		try {
			Connection conn = DBConnection.openConnection();
			conn = DBConnection.openConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(getAll);
			while (resultSet.next()) {
				module.setName(resultSet.getString("name"));
				module.setStartDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("startDate")));
				module.setEndDate(DateUtils.sqlDateToCalendar(resultSet
						.getDate("endDate")));
				modules.add(module);
			}
			logger.info("all enries was sucsessfully retrieved! ");
			DBConnection.close(resultSet);
			DBConnection.close(statement);
			DBConnection.closeConnection();
		} catch (SQLException e) {
			logger.info("Cannot read from DB " + e);
		}
		return modules;
	}

	@Override
	public boolean deleteAll() {
		String deleteAll = "DELETE FROM modules";
		try {
			Connection conn = DBConnection.openConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(deleteAll);
			rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				logger.info("All record are deleted from table modules ");
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
