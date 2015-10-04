package edu.diary.repository;

import java.util.Set;

import edu.diary.domain.ICourse;

public interface CourseRepository {
  
  // Course course = null. if id!=null -> update
  ICourse save(ICourse course);

  //    false if not found
  void delete(int id);

  ICourse get(int id);

  // null if not found
  Set<ICourse> getAll();

  void deleteAll();

}
