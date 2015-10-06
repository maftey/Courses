package edu.diary.repository.jdbc;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;
import edu.diary.util.TablesCreator;
import edu.diary.util.TestCourseData;

public class JdbcCourseRepositoryImplTest {
	private CourseRepository courseRepository = new JdbcCourseRepositoryImpl();

	@BeforeMethod
	public void setUp() {
		TablesCreator dbCreator = new TablesCreator();
		dbCreator.createDB();
	}

	@Test
	public void delete() {
		assertEquals(courseRepository.delete("JAVA.Basics"), true);
	}

	@Test
	public void get() {
		
	}

	@Test
	public void getAll() {
		Set<Course>testSet = new TreeSet<Course>();
		testSet = courseRepository.getAll();
		assertEquals(true, (!testSet.isEmpty()));
	}

	@Test
	public void save() {
		Course savedCourse = courseRepository.save(TestCourseData
				.testJavaCourse());
		Course retrievedCourse = courseRepository.get("JAVA.NEW");
		assertEquals(savedCourse, retrievedCourse);
	}

	@Test
	public void update() {
		Course updateCourse = courseRepository.update(TestCourseData
				.testJavaCourse());
		assertEquals(true, (JdbcCourseRepositoryImpl.getRows() > 0));
	}

	@Test
	public void deleteAll() {
		assertEquals(courseRepository.deleteAll(), true);
	}
}
