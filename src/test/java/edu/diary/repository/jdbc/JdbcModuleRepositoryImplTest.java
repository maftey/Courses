package edu.diary.repository.jdbc;

import static edu.diary.util.TestCourseData.CREATEDCOURSE;
import static edu.diary.util.TestCourseData.DOTNETCOURSE;
import static edu.diary.util.TestCourseData.JAVAMODULE1;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.diary.domain.Module;
import edu.diary.repository.ModuleRepository;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestCourseData.TestModule;

public class JdbcModuleRepositoryImplTest {
	
	private ModuleRepository repository = new JdbcModuleRepositoryImpl();
	private DBInitialisator initialisator = new DBInitialisator();
	
	@BeforeMethod
	public void setUpDatabase() {
		initialisator.resetDatabase();
		initialisator.populateDatabase();
	}

  @Test
  public void delete() {
	  repository.delete("JAVA.Basics");
		Set<Module> expected = new TreeSet<Module>();
		expected.add(DOTNETCOURSE);
		assertEquals(expected, repository.getAll());
  }

  @Test
  public void deleteAll() {
	  repository.deleteAll();
		Set<Module> expected = new TreeSet<Module>();
		expected = repository.getAll();
		assertEquals(0, expected.size());
  }

  @Test
  public void get() {
	  Module actual = repository.get(JAVAMODULE1.getName());
		assertEquals(JAVAMODULE1, actual);
  }

  @Test
  public void getAll() {
	  Set<Module> actual = new TreeSet<Module>();
		Set<Module> expected = new TreeSet<Module>();
		expected.add(JAVAMODULE1);
		expected.add(DOTNETCOURSE);
		actual = repository.getAll();
		assertEquals(expected, actual);
  }

  @Test
  public void getAllForCourse() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
	  Module saved = repository.save(CREATEDCOURSE);
		assertEquals(CREATEDCOURSE, repository.get(CREATEDCOURSE.getName()));
  }

  @Test
  public void update() {
	  TestModule updated = new TestModule(JAVAMODULE1);
		updated.setDescription("Updated from TestCourseData");
		repository.update(updated);
		assertEquals(updated, repository.get(updated.getName()));
  }
}
