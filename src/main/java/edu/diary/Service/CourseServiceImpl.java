
package edu.diary.Service;

import java.util.Set;

import edu.diary.domain.Course;
import edu.diary.repository.CourseRepository;

public class CourseServiceImpl implements CourseRepository {
  
  private CourseRepository courseRepository = new CourseServiceImpl();

  @Override
  public Course save(Course course) {
    return null;
  }

  @Override
  public void delete(int id) {
    //TODO: impl
  }
  
  @Override
  public Course get(int id) {
    return null;
  }

  @Override
  public Set<Course> getAll() {
   
    return null;
  }

  @Override
  public void deleteAll() {
  }
}  
    

 
  

 




