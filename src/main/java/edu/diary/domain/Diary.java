package edu.diary.domain;

import static edu.diary.util.TestModuleData.CREATEDMODULE;
import static edu.diary.util.TestCourseData.JAVACOURSE;
import static edu.diary.util.TestTestData.CREATEDTEST;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.diary.repository.CourseRepository;
import edu.diary.repository.ModuleRepository;
import edu.diary.repository.TestRepository;
import edu.diary.repository.jdbc.JdbcCourseRepositoryImpl;
import edu.diary.repository.jdbc.JdbcModuleRepositoryImpl;
import edu.diary.repository.jdbc.JdbcTestRepositoryImpl;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestModuleData;
import edu.diary.util.TestTestData;

/**
 * Created by Roman and Michael on 22.09.2015.
 */
public class Diary {

	public static void main(String[] args) throws IOException, SQLException {
		Logger logger = Logger.getLogger("Diary");
		logger.setLevel(Level.ALL);
		ModuleRepository repository = new JdbcModuleRepositoryImpl();

		DBInitialisator dbInit = new DBInitialisator();
//		dbInit.resetDatabase();
//		dbInit.populateDatabase();
		
		TestRepository tRepository = new JdbcTestRepositoryImpl();
		tRepository.save(CREATEDTEST);
//		tRepository.get(CREATEDTEST.getName());
//		
//		
		
		
		
		
//		TestTestData.TestTest updated = new TestTestData.TestTest(CREATEDTEST);
//		tRepository.save(CREATEDTEST);
//		updated.setPassedScore(777);
//		tRepository.update(updated, CREATEDTEST.getId());
//		tRepository.delete(updated.getName());
//		tRepository.getAll();
//		tRepository.deleteAll();
		
		
		
		
//		repository.save(CREATEDMODULE);
//
//		repository.get(CREATEDMODULE.getName());

//		TestModuleData.TestModule updated = new TestModuleData.TestModule(
//				CREATEDMODULE);
//		repository.save(CREATEDMODULE);
//		updated.setDescription("Updated from TestCourseData");
//		logger.info("test update. course =  " + updated);
//		repository.update(updated,CREATEDMODULE.getId());
//		repository.get(CREATEDMODULE.getName());

		//		repository.getAllForCourse(JAVACOURSE);
//		repository.delete(CREATEDMODULE.getName());
//
//		repository.getAll();
//		repository.deleteAll();

	}

}
