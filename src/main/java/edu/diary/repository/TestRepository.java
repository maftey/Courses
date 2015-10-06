package edu.diary.repository;

import java.util.Set;
import edu.diary.domain.Test;

public interface TestRepository {
	Test save(Test test);

	// false if not found
	boolean delete(String name);

	Test get(String name);

	// null if not found
	Set<Test> getAll();

	boolean deleteAll();

	Test update(Test test);

}
