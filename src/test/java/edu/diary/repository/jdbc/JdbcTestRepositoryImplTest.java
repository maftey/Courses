package edu.diary.repository.jdbc;

import static edu.diary.util.TestTestData.CREATEDTEST;
import static edu.diary.util.TestTestData.DOTNETTEST1;
import static edu.diary.util.TestTestData.DOTNETTEST2;
import static edu.diary.util.TestTestData.JAVATEST1;
import static edu.diary.util.TestTestData.JAVATEST2;
import static edu.diary.util.TestTestData.JAVATEST3;
import static edu.diary.util.TestTestData.JAVATEST4;
import static edu.diary.util.TestTestData.JAVATEST5;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.diary.domain.Tests;
import edu.diary.repository.TestRepository;
import edu.diary.util.DBInitialisator;
import edu.diary.util.TestTestData;

public class JdbcTestRepositoryImplTest {

	private TestRepository repository = new JdbcTestRepositoryImpl();
	private DBInitialisator initialisator = new DBInitialisator();

	@BeforeMethod
	public void setUpDatabase() {
		initialisator.resetDatabase();
		initialisator.populateDatabase();
	}

	@Test
	public void delete() {

		repository.delete("test1");
		Set<Tests> expected = new TreeSet<Tests>();
		expected.add(JAVATEST2);
		expected.add(JAVATEST3);
		expected.add(JAVATEST4);
		expected.add(JAVATEST5);
		expected.add(DOTNETTEST1);
		expected.add(DOTNETTEST2);
		assertEquals(expected, repository.getAll());

	}

	@Test
	public void deleteAll() {
		repository.deleteAll();
		Set<Tests> expected = new TreeSet<Tests>();
		expected = repository.getAll();
		assertEquals(0, expected.size());
	}

	@Test
	public void get() {
		Tests actual = repository.get(JAVATEST1.getName());
		assertEquals(JAVATEST1, actual);
	}

	@Test
	public void getAll() {
		Set<Tests> actual = new TreeSet<Tests>();
		Set<Tests> expected = new TreeSet<Tests>();
		expected.add(JAVATEST1);
		expected.add(JAVATEST2);
		expected.add(JAVATEST3);
		expected.add(JAVATEST4);
		expected.add(JAVATEST5);
		expected.add(DOTNETTEST1);
		expected.add(DOTNETTEST2);
		actual = repository.getAll();
		assertEquals(expected, actual);
	}

	@Test
	public void save() {
		Tests saved = repository.save(CREATEDTEST);
		assertEquals(CREATEDTEST, repository.get("new Test"));
	}

	@Test
	public void update() {
		TestTestData.TestTest updated = new TestTestData.TestTest(JAVATEST1);
		updated.setDescription("Updated from TestTestData");
		repository.update(updated, JAVATEST1.getId());
		assertEquals(updated, repository.get(updated.getName()));
	}
}
