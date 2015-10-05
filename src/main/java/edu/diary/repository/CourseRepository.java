package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.Course;

public interface CourseRepository {
  
  
  Course save(Course course);

  //    false if not found
  void delete(int id);

  Course get(int id);

  // null if not found
  Set<Course> getAll();

  void deleteAll();

Course update(Course course);

}
