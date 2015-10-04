
package edu.diary.Service;

import java.util.Set;

import edu.diary.domain.ICourse;
import edu.diary.repository.CourseRepository;

public class CourseServiceImpl implements CourseRepository {
  
  private CourseRepository courseRepository = new CourseServiceImpl();

  @Override
  public ICourse save(ICourse course) {
    return null;
  }

  @Override
  public void delete(int id){
  }
  
  @Override
  public ICourse get(int id) {
    return null;
  }

  @Override
  public Set<ICourse> getAll() {
   
    return null;
  }

  @Override
  public void deleteAll() {
  }
}  
    

 
  

 




