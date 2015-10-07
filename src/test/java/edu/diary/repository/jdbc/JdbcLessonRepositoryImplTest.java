package edu.diary.repository.jdbc;

import static edu.diary.util.TestCourseData.CREATEDCOURSE;
import static edu.diary.util.TestCourseData.DOTNETCOURSE;
import static edu.diary.util.TestCourseData.JAVACOURSE;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.repository.LessonRepository;
import edu.diary.util.DBInitialisator;

public class JdbcLessonRepositoryImplTest {
	private LessonRepository repository = new JdbcLessonRepositoryImpl();
	private DBInitialisator initialisator = new DBInitialisator();

	@BeforeMethod
	public void setUpDatabase() {
		initialisator.resetDatabase();
		initialisator.populateDatabase();
	}


  @Test
  public void delete() {
	  repository.delete("JAVA.Basics");
		Set<Course> expected = new TreeSet<Course>();
		expected.add(DOTNETCOURSE);
		assertEquals(expected, repository.getAll());
  }

  @Test
  public void deleteAll() {
	  repository.deleteAll();
		Set<Course> expected = new TreeSet<Course>();
		expected = repository.getAll();
		assertEquals(0, expected.size());
  }

  @Test
  public void get() {
	  Course actual = repository.get(JAVACOURSE.getName());
		assertEquals(JAVACOURSE, actual);
  }

  @Test
  public void getAll() {
	  Set<Course> actual = new TreeSet<Course>();
		Set<Course> expected = new TreeSet<Course>();
		expected.add(JAVACOURSE);
		expected.add(DOTNETCOURSE);
		actual = repository.getAll();
		assertEquals(expected, actual);
  }

  @Test
  public void getAllForModule() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
	  Course saved = repository.save(CREATEDCOURSE);
		assertEquals(CREATEDCOURSE, repository.get(CREATEDCOURSE.getName()));
  }

  @Test
  public void update() {
	  Course updated = getUpdated();
		repository.update(updated);
		assertEquals(updated, repository.get(JAVACOURSE.getName()));
}
}
