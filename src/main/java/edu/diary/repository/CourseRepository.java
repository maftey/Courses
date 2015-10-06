package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Course;

public interface CourseRepository {

	Course save(Course course);

	
	boolean delete(String name);

	Course get(String name);

	
	Set<Course> getAll();

	boolean deleteAll();

	Course update(Course course);

}
