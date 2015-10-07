package edu.diary.domain;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Roma class stores info about course modules
 */
public class Module extends AbstractUnit implements Comparable<Module> {
  
  //TODO: maybe List? or something with order
  private Set<Lesson> lessons = new TreeSet<>();
  
  private int courseId;

  public Set<Lesson> getLessons() {
    return lessons;
  }
  public void setLessons(Set<Lesson> lessons) {
    this.lessons = lessons;
  }
  
  public int getCourseId() {
    return courseId;
  }
  
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  
@Override
  public int compareTo(Module other) {//TODO: maybe move into base
    return getId() - other.getId();
  }
 
  @Override
  public String toString() {
    return " Module{" 
          + "id= " + getId()
          + ", name: " + getName()
          + ", enabled: " + isEnabled()
          + "}";
  }
  
  
    
}
