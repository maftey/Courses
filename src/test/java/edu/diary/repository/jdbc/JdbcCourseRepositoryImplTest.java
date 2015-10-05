package edu.diary.repository.jdbc;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.util.TablesCreator;
import static edu.diary.util.TestCourseData.JAVACOURSE;;


public class JdbcCourseRepositoryImplTest {
	private CourseRepository courseRepository = new JdbcCourseRepositoryImpl();

	@BeforeClass
	public void setUp() {
		TablesCreator dbCreator = new TablesCreator();
		dbCreator.createDB();
	}

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
		Course savedCourse = courseRepository.save(JAVACOURSE);
		Course retrievedCourse = courseRepository.get(1);
		assertEquals(JAVACOURSE, retrievedCourse);
	}

	@Test
	public void update() {
		throw new RuntimeException("Test not implemented");
	}
}
