package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Question;

public interface QuestionRepository {
	Question save(Question module);

	// false if not found
	boolean delete(String name);

	Question get(String name);
	
	Set<Question> getAll();

	// null if not found
	boolean deleteAll();

	Question update(Question question);

}
