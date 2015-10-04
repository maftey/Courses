package edu.diary.domain;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Roma class stores info about course modules
 */
public class Module extends BaseName implements Comparable<IModule>, IModule {
  
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
  @XmlTransient
  protected int userScore;
  
  protected boolean passed;
  
  public Module() {
  }
  public Module(int id, String name) {
    super(id, name);
  }
  public Module(int id, String name, boolean isEnabled, int userScore) {
    super(id, name);
    this.isEnabled = isEnabled;
    this.userScore = userScore;
  }
  @JsonCreator
  public Module(@JsonProperty("id")Integer id,
                    @JsonProperty("name")String name) {
      super(id, name);
      
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

  

  /* 
   * @see edu.diary.domain.ModuleInterface#checkPassed(int)
   */
  public void checkPassed(int aUserScore) {
    if (userScore < passingScore) {
     setPassed(false);
    } else {
      setPassed(true);  
    }
  }
  
  /* 
   * @see edu.diary.domain.ModuleInterface#getPassed()
   */
  public boolean getPassed() {
    return passed;
  }
  public boolean setPassed(boolean aPassed) {
    return passed = aPassed;
  }
  /* 
   * @see edu.diary.domain.ModuleInterface#setPassingScore(int)
   */
  public void setPassingScore(int passingScore) {
    this.passingScore = passingScore;
  }
  
  /* 
   * @see edu.diary.domain.ModuleInterface#getPassingScore()
   */
  public int getPassingScore() {
    return passingScore;
  }

  /* 
   * @see edu.diary.domain.ModuleInterface#compareTo(edu.diary.domain.Module)
   */
  @Override
  public int compareTo(IModule other) {
    return getId() - other.getId();
  }
 
  @Override
  public String toString() {
    return " Module{" 
          + "id= " + getId()
          + ", name: " + getName()
          + ", enabled: " + isEnabled()
          + ", passed: " + getPassed() 
          + "}";
  }
  
 
    
}
