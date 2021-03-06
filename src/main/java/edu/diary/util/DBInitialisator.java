package edu.diary.util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBInitialisator {

	private static Logger LOG = Logger.getLogger("DBCreator");

	public void resetDatabase() {
		try {
			Connection conn = DBConnection.openConnection();
			String initDB = "DROP TABLE IF EXISTS questions; "
					+ "DROP TABLE IF EXISTS lessons; "
					+ "DROP TABLE IF EXISTS tests; "
					+ "DROP TABLE IF EXISTS modules; "
					+ "DROP TABLE IF EXISTS courses; "
					+ "DROP SEQUENCE IF EXISTS courses_seq; "
					+ "DROP SEQUENCE IF EXISTS modules_seq; "
					+ "DROP SEQUENCE IF EXISTS tests_seq; "
					+ "DROP SEQUENCE IF EXISTS questions_seq; "
					+ "DROP SEQUENCE IF EXISTS lessons_seq; "
					+ "CREATE SEQUENCE courses_seq START 1; "
					+ "CREATE SEQUENCE modules_seq START 1; "
					+ "CREATE SEQUENCE tests_seq START 1; "
					+ "CREATE SEQUENCE questions_seq START 1; "
					+ "CREATE SEQUENCE lessons_seq START 1; "
					+ "CREATE TABLE courses( "
					+ "id       INTEGER PRIMARY KEY DEFAULT nextval('courses_seq'), "
					+ "name      VARCHAR (50) NOT NULL, "
					+ "startdate DATE NOT NULL, "
					+ "enddate  	DATE NOT NULL, "
					+ "isenabled BOOLEAN DEFAULT TRUE, "
					+ "description VARCHAR(300), "
					+ "test_id	INTEGER ); "
					+ "CREATE TABLE modules( "
					+ "id        INTEGER PRIMARY KEY DEFAULT nextval('modules_seq'), "
					+ "name       VARCHAR (50) NOT NULL, "
					+ "startdate DATE NOT NULL, "
					+ "enddate  	DATE NOT NULL, "
					+ "description VARCHAR(300), "
					+ "isenabled	 BOOLEAN DEFAULT TRUE, "
					+ "course_id  INTEGER NOT NULL, "
					+ "test_id	INTEGER, "
					+ "FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE); "
					+ "CREATE TABLE tests( "
					+ "id        INTEGER PRIMARY KEY DEFAULT nextval('tests_seq'), "
					+ "name      VARCHAR (50) NOT NULL, "
					+ "startdate DATE NOT NULL, "
					+ "enddate  	DATE NOT NULL, "
					+ "isenabled BOOLEAN DEFAULT TRUE, "
					+ "passedscore INTEGER ); "
					+ "CREATE TABLE questions( "
					+ "id        INTEGER PRIMARY KEY DEFAULT nextval('questions_seq'), "
					+ "text 		VARCHAR (10000), "
					+ "score 	INTEGER, "
					+ "test_id	INTEGER NOT NULL, "
					+ "FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE); "
					+ "CREATE TABLE lessons( "
					+ "id         INTEGER PRIMARY KEY DEFAULT nextval('lessons_seq'), "
					+ "name       VARCHAR (50) NOT NULL, "
					+ "startdate DATE NOT NULL, "
					+ "enddate  	DATE NOT NULL, "
					+ "description VARCHAR(300), "
					+ "isenabled	 BOOLEAN DEFAULT TRUE, "
					+ "text VARCHAR (10000), "
					+ "module_id  INTEGER NOT NULL, "
					+ "test_id	INTEGER, "
					+ "FOREIGN KEY (module_id) REFERENCES modules (id) ON DELETE CASCADE);";
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(initDB);
			if (rows > 0) {
				LOG.info("Tables created successfully");
			}
			DBConnection.close(stmt);
			DBConnection.closeConnection();
		} catch (Exception e) {
			LOG.info("Tables didn't created! " + e);
		}
	}

	public void populateDatabase() {
		try {
			Connection conn = DBConnection.openConnection();
			String initDB = "DELETE FROM lessons; DELETE FROM questions; "
					+ "DELETE FROM tests; DELETE FROM modules; DELETE FROM courses; "
					+ "INSERT INTO courses ("
					+ "name, startdate, enddate, isenabled, description, test_id ) VALUES "
					+ "('JAVA.Basics', '07-Oct-2015', '10-Feb-2016',true, 'Java Core', 1); "
					+ "INSERT INTO courses (name, startDate, endDate, isenabled, description, test_id) "
					+ "VALUES ('DotNet for beginners', '07-Oct-2015', '20-Mar-2016', true, 'Dot Net', 2); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test1','10-Feb-2016', '10-Feb-2016', true, 50); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test2','14-Oct-2015', '14-Oct-2015', true, 75); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test3','18-Oct-2015', '18-Oct-2015', true, 75); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test4','24-Oct-2015', '24-Oct-2015', true, 75); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test5','30-Oct-2015', '30-Oct-2015', true, 75); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test6', '10-Oct-2015', '10-Oct-2015', true, 75); "
					+ "INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) "
					+ "VALUES ('test7', '14-Oct-2015', '14-Oct-2015', true, 75); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('java module1','07-Oct-2015', '10-Oct-2015', 'Introducing',true, 1, 1); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('java module2','11-Oct-2015', '14-Oct-2015', 'Objects and classes',true, 1, 2); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('java module3','15-Oct-2015', '18-Oct-2015', 'Inheritance',true, 1, 3); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('java module4','21-Oct-2015', '24-Oct-2015', 'Interfaces and nested classes',true, 1, 4); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('java module5','27-Oct-2015', '30-Oct-2015', 'Generics',true, 1, 5); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('dotNet module1', '07-Oct-2015', '10-Oct-2015', 'Introducing to .Net',true, 2, 6); "
					+ "INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id, test_id) "
					+ "VALUES ('dotNet module2', '11-Oct-2015', '14-Oct-2015','Collections',true, 2, 7); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test1',50, 1); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test2',50, 2); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test3',50, 3); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test4',50, 4); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test5',50, 5); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test6',50, 6); "
					+ "INSERT INTO questions (text, score, test_id) VALUES ('question for test7',50, 7); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 1','08-Oct-2015', '9-Oct-2015', 'decription may be here', true,  'text of lesson of module 1', 1, 1); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 2','12-Oct-2015', '13-Oct-2015', 'decription may be here',true,  'text of lesson of module 2', 2, 2); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 3','16-Oct-2015', '17-Oct-2015', 'decription may be here',true,  'text of lesson of module 3', 3, 3); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 4','22-Oct-2015', '23-Oct-2015', 'decription may be here',true,  'text of lesson of module 4', 4, 4); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 5','28-Oct-2015', '29-Oct-2015', 'decription may be here',true,  'text of lesson of module 5', 5, 5); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 6','08-Oct-2015', '09-Oct-2015', 'decription may be here',true,  'text of lesson of module 6', 6, 6); "
					+ "INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id, test_id) "
					+ "VALUES ('lesson 7','12-Oct-2015', '14-Oct-2015', 'decription may be here',true,  'text of lesson of module 7', 7, 7); ";
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(initDB);
			if (rows > 0) {
				LOG.info("Tables populated successfully");
			}
			DBConnection.close(stmt);
			DBConnection.closeConnection();
		} catch (Exception e) {
			LOG.info("Tables didn't populated!" + e);
		}
	}
}
