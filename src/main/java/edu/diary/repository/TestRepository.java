package edu.diary.repository;

import java.util.Set;
import edu.diary.domain.Tests;

public interface TestRepository {
	Tests save(Tests test);
	
	Tests update(Tests test, int id);
	// false if not found
	boolean delete(String name);

	Tests get(String name);

	// null if not found
	Set<Tests> getAll();

	boolean deleteAll();

	

}
