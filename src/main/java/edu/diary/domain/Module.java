package edu.diary.domain;

import java.util.Set;
import java.util.TreeSet;


/**
 * @author Roma class stores info about course modules
 */

public class Module extends BaseName implements Comparable<Module> {
  
  /**
   * set ups threshold score to pass module on exam
   */
  private int passingScore = 75; 

  /**
   * flag. shows enabled/disabled module
   */
  protected boolean isEnabled = true;
  
  /**
   * flag. shows passed/failed module
   */
  
  protected int userScore;
  
  protected boolean passed;
  
  public Module() {
  }
  public Module(int id, String name) {
    super();
  }
  public Module(int id, String name, boolean isEnabled, int userScore) {
    super();
    this.isEnabled = isEnabled;
    this.userScore = userScore;
  }
  
  
  /* 
   * @see edu.diary.domain.ModuleInterface#isEnabled()
   */
  public boolean isEnabled() {
    return isEnabled;
  }
  
  /* 
   * @see edu.diary.domain.ModuleInterface#setEnabled(boolean)
   */
  public void setEnabled(boolean aIsEnabled) {
    this.isEnabled = aIsEnabled;
  }

  //TODO: maybe List? or something with order
  private Set<Lesson> lessons = new TreeSet<>();

  public Set<Lesson> getLessons() {
    return lessons;
  }
  public void setLessons(Set<Lesson> lessons) {
    this.lessons = lessons;
  }
  /* 
   * @see edu.diary.domain.ModuleInterface#compareTo(edu.diary.domain.Module)
   */
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
