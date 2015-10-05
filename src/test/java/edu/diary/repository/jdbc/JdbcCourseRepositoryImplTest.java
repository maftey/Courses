package edu.diary.repository.jdbc;

import org.testng.annotations.Test;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;

public class JdbcCourseRepositoryImplTest {
	CourseRepository courseRepository = new JdbcCourseRepositoryImpl();
  
 
  @Test
  public void delete() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteAll() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void get() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAll() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
	 final  Course COURSE = new Course("JAVA.Basics", "12.4/2016","04.05.2016");
	 Course createdCourse = courseRepository.save(COURSE);
	 
	 
	  
  }

  @Test
  public void update() {
    throw new RuntimeException("Test not implemented");
  }
}
