package edu.diary.repository.jdbc;

import static edu.diary.util.TestCourseData.CREATEDCOURSE;
import static edu.diary.util.TestCourseData.DOTNETCOURSE;
import static edu.diary.util.TestCourseData.JAVACOURSE;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestCourseData;
import edu.diary.util.TestCourseData.TestCourse;

public class JdbcCourseRepositoryImplTest {

	private static Logger logger = Logger.getLogger("JdbcCourseRepositoryTest");
	private CourseRepository repository = new JdbcCourseRepositoryImpl();
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
	public void testSave() {
		Course saved = repository.save(CREATEDCOURSE);
		assertEquals(CREATEDCOURSE, repository.get(CREATEDCOURSE.getName()));
	}

	@Test
	public void testGet() {
		Course actual = repository.get(JAVACOURSE.getName());
		assertEquals(JAVACOURSE, actual);
	}

	@Test
	public void update() {
		TestCourse updated = new TestCourse(JAVACOURSE);
		updated.setDescription("Updated from TestCourseData");
		repository.update(updated);
		assertEquals(updated, repository.get(JAVACOURSE.getName()));

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
	public void deleteAll() {
		repository.deleteAll();
		Set<Course> expected = new TreeSet<Course>();
		expected = repository.getAll();
		assertEquals(0, expected.size());
	}

	// @Test//(expectedExceptions = NotFoundException.class)
	// public void testDeleteNotFound() throws Exception {
	//
	// }

	// @Test(expectedExceptions = NotFoundException.class)
	// public void testGetNotFound() throws Exception {
	// repository.get("asdasd");
	// }

	// @Test(expectedExceptions = NotFoundException.class)
	// public void testNotFoundUpdate() throws Exception {
	// repository.update(PHPCOURSE);
	// }
}
