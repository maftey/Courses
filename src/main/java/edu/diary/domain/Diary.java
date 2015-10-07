package edu.diary.domain;

import static edu.diary.util.TestCourseData.JAVACOURSE;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.diary.repository.CourseRepository;
import edu.diary.repository.ModuleRepository;
import edu.diary.repository.jdbc.JdbcCourseRepositoryImpl;
import edu.diary.repository.jdbc.JdbcModuleRepositoryImpl;
import edu.diary.repository.jdbc.JdbcModuleRepositoryImplTest;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestCourseData;
import edu.diary.util.TestCourseData.TestCourse;

/**
 * Created by Roman and Michael on 22.09.2015.
 */
public class Diary {

	public static void main(String[] args) throws IOException, SQLException {
		Logger logger = Logger.getLogger("Diary");
		logger.setLevel(Level.ALL);

		// repository inintialisation

		CourseRepository courseRep = new JdbcCourseRepositoryImpl();
		ModuleRepository moduleRep = new JdbcModuleRepositoryImpl();
		
		TestCourse updated = new TestCourse(JAVACOURSE);
		updated.setDescription("Updated from TestCourseData");
		logger.info("test update. course =  " + updated);
		
		courseRep.get("dwefwef");

//		repository.save(javaCourse);
//		 repository.get("JAVA.NEW");
//		 repository.update(TestCourseData.testJavaCourse());
		
//		// repository.save(course2);
//		Set<Course> courseSet = courseRep.getAll();
//        for(Course course: courseSet){
//        	System.out.println(course);
//        	Set<Module> mosuleSet = moduleRep.getAllForCourse(course);
//        	for(Module module: mosuleSet){
//        		System.out.println(module);
//        	}
        }
		
	}

