package edu.diary.domain;

import java.util.Set;
import java.util.TreeSet;


/**
 * @author Roma Representation of course and modules.
 */
//TODO:Comparable move in base
public class Course extends AbstractUnit implements Comparable<Course> {
  

  
  //TODO: maybe List? or something with order
  private Set<Module> modules = new TreeSet<>();
  
  public Set<Module> getModules() {
    return modules;
  }

  public Course addModule(Module aModule) {
    modules.add(aModule);
    return this;
  }

  public int compareTo(Course other) {//ToDO maybe move to Base
    return getId() - other.getId();
  }

  @Override
  public String toString() {
    return "Course{" 
           + " id= " + getId() 
           + ", name: " + getName() 
           + ", Start date: " + formatDate(getStartDate()) 
           + ", End date: " + formatDate(getEndDate())
           + " }"; 
  }
 
}
