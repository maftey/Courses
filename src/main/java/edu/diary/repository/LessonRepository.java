package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Lesson;

public interface LessonRepository {

	Lesson save(Lesson module);

	// false if not found
	boolean delete(String name);

	Lesson get(String name);

	// null if not found
	Set<Lesson> getAll();

	boolean deleteAll();

	Lesson update(Lesson lesson);

}
