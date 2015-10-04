package edu.diary.domain;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Roma Representation of course and modules.
 */
public class Course extends BaseName implements Comparable<ICourse>, ICourse {
  

  @XmlElement(name = "startDate")
  private Calendar startDate = new GregorianCalendar();

  @XmlElement(name = "endDate")
  private Calendar endDate = new GregorianCalendar();

  @XmlElementWrapper(name = "modules")
  @XmlElement(type = Module.class, name = "module")
  private Set<IModule> modules = new TreeSet<>();
  
  public Course() {
  }
  
  
  public Course(Integer id, String name, 
          Calendar startDate, Calendar endDate) {
    super(id, name);
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  public Course(Integer id, String name, Calendar startDate, 
                    Calendar endDate, IModule...modules) {
    super(id, name);
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  @JsonCreator
  public Course(@JsonProperty("id")int id, 
      @JsonProperty("name")String name, 
      @JsonProperty("startDate")Calendar startDate, 
      @JsonProperty("endDate")Calendar endDate) {
      super(id, name);
      this.startDate = startDate;
      this.endDate = endDate;
  }

  /**
   * @see edu.diary.domain.ICourse#getStartDate()
   */
  @Override
  public Calendar getStartDate() {
    return startDate;
  }
  
  /**
   * @see edu.diary.domain.ICourse#getEndDate()
   */
  @Override
  public Calendar getEndDate() {
    return endDate;
  }
  
  public void getFEndDate() {
   System.out.println(formatDate(startDate));
  }
  /**
   * @see edu.diary.domain.ICourse#setStartDate(int, int, int)
   */
  @Override
  public void setStartDate(int day, int month, int year) {
//    startDate = new GregorianCalendar(year, month, day);
  
    startDate.set(Calendar.DAY_OF_MONTH, day);
    startDate.set(Calendar.MONTH, (month-1));
    startDate.set(Calendar.YEAR, year);
    
  }

  /**
   * 
   * 
   * @see edu.diary.domain.ICourse#setEndDate(int, int, int)
   */
  @Override
  public void setEndDate(int day, int month, int year) {

    endDate.set(Calendar.DAY_OF_MONTH, day);
    endDate.set(Calendar.MONTH, (month-1));
    endDate.set(Calendar.YEAR, year);
  }

  
  /**
   * @see edu.diary.domain.ICourse#getModules()
   */
  @Override
  public Set<IModule> getModules() {
    return modules;
  }

  /**
   * @see edu.diary.domain.ICourse#addModule(edu.diary.domain.module.BaseModule)
   */
  @Override
  public ICourse addModule(IModule aModule) {
    modules.add(aModule);
    return this;
  }

  /**
   * @see edu.diary.domain.ICourse#formatDate(java.util.Calendar)
   */

  @Override
  public String formatDate(Calendar unformattedDate) {
    Date date = unformattedDate.getTime();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    return (String) dateFormat.format(date);
  }
  
  @Override
  public int compareTo(ICourse other) {
    return getId() - other.getId();
  }

  @Override
  public String toString() {
    return "Course{" 
           + "id= " + getId() 
           + ", name: " + getName() 
           + ", Start date: " + formatDate(getStartDate()) 
           + ", End date: " + formatDate(getEndDate()) 
           + ", modules: " + getModules();
  }
 
}
