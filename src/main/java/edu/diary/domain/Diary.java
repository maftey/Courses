package edu.diary.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.diary.repository.CourseRepository;
import edu.diary.repository.jdbc.JdbcCourseRepositoryImpl;
import edu.diary.repository.jdbc.JdbcModuleRepositoryImpl;
import edu.diary.util.TablesCreator;
import edu.diary.util.TestCourseData;

/**
 * Created by Roma on 22.09.2015.
 */
public class Diary {

	public static void main(String[] args) throws IOException, SQLException {
		Logger LOG = Logger.getLogger("Diary");
		LOG.setLevel(Level.ALL);

		// repository inintialisation

		JdbcCourseRepositoryImpl courseRep = new JdbcCourseRepositoryImpl();
		JdbcModuleRepositoryImpl moduleRep = new JdbcModuleRepositoryImpl();

		// creating tables in database
//		 TablesCreator dbCreator = new TablesCreator();
//		 dbCreator.createDB();

		/*Course javaCourse = new Course();
		javaCourse.setName("JAVA.NEW");
		javaCourse.setStartDate(01, 10, 2016);
		javaCourse.setEndDate(29, 12, 2016);
		javaCourse.setEnabled(true);
		javaCourse.setDescription("sdwehfuiwhfiuhwefuihweuifi");*/

//		repository.save(javaCourse);
//		 repository.get("JAVA.NEW");
//		 repository.update(TestCourseData.testJavaCourse());
		
		// repository.save(course2);
		Set<Course> courseSet = courseRep.getAll();
        for(Course course: courseSet){
        	System.out.println(course);
        	Set<Module> mosuleSet = moduleRep.getAllForCourse(course);
        	for(Module module: mosuleSet){
        		System.out.println(module);
        	}
        }
				  
		 //System.out.println(set);
		// repository.get(1);
		// repository.delete(1);
		// repository.deleteAll();
		// repository.getAll();
		

	}
}
