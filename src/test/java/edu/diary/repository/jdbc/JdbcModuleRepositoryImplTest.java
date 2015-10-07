package edu.diary.repository.jdbc;

import static edu.diary.util.TestModuleData.CREATEDMODULE;
import static edu.diary.util.TestModuleData.DOTNETMODULE1;
import static edu.diary.util.TestModuleData.DOTNETMODULE2;
import static edu.diary.util.TestModuleData.JAVAMODULE1;
import static edu.diary.util.TestModuleData.JAVAMODULE2;
import static edu.diary.util.TestModuleData.JAVAMODULE3;
import static edu.diary.util.TestModuleData.JAVAMODULE4;
import static edu.diary.util.TestModuleData.JAVAMODULE5;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.diary.domain.Module;
import edu.diary.repository.ModuleRepository;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestModuleData;
import edu.diary.util.TestModuleData.TestModule;

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
	  repository.delete("java module1");
		Set<Module> expected = new TreeSet<Module>();
		expected.add(JAVAMODULE2);
		expected.add(JAVAMODULE3);
		expected.add(JAVAMODULE4);
		expected.add(JAVAMODULE5);
		expected.add(DOTNETMODULE1);
		expected.add(DOTNETMODULE2);
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
		expected.add(JAVAMODULE2);
		expected.add(JAVAMODULE3);
		expected.add(JAVAMODULE4);
		expected.add(JAVAMODULE5);
		expected.add(DOTNETMODULE1);
		expected.add(DOTNETMODULE2);
		actual = repository.getAll();
		assertEquals(expected, actual);
  }

  @Test
  public void getAllForCourse() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
	  Module saved = repository.save(CREATEDMODULE);
		assertEquals(CREATEDMODULE, repository.get("new Module"));
  }

  @Test
  public void update() {
	  TestModuleData.TestModule updated = new TestModuleData.TestModule(JAVAMODULE1);
		updated.setDescription("Updated from TestCourseData");
		repository.update(updated);
		assertEquals(updated, repository.get(updated.getName()));
  }
}
