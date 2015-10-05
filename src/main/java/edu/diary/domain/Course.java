package edu.diary.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import edu.diary.util.DateUtils;

/**
 * @author Roma Representation of course and modules.
 */

public class Course extends BaseName implements Comparable<Course>{
  

  @XmlElement(name = "startDate")
  private Calendar startDate = new GregorianCalendar();

  @XmlElement(name = "endDate")
  private Calendar endDate = new GregorianCalendar();

  @XmlElementWrapper(name = "modules")
  @XmlElement(type = Module.class, name = "module")
  private Set<Module> modules = new TreeSet<>();
  
  public Course() {
  }
    
  public Course(Integer id, String name, 
          Calendar startDate, Calendar endDate) {
    super();
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  public Course(Integer id, String name, Calendar startDate, 
                    Calendar endDate, Module...modules) {
    super();
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
   public Course(int startSeq, String string, String string2, String string3) {
	
}

public Course(String name, String startDate, String endDate) {

}

/**
   * @see edu.diary.domain.ICourse#getStartDate()
   */
 
  public Calendar getStartDate() {
    return startDate;
  }
  
  /**
   * @see edu.diary.domain.ICourse#getEndDate()
   */
 
  public Calendar getEndDate() {
    return endDate;
  }
  
  public void getFEndDate() {
   System.out.println(formatDate(startDate));
  }
  /**
   * @see edu.diary.domain.ICourse#setStartDate(String date)
   */
  
  public void setStartDate(String ddmmyyyy) {
	  String day_month_year = ddmmyyyy;
	  startDate = DateUtils.convertFromDMY(day_month_year);
  }

  
  /**
   * 
   * 
   * @see edu.diary.domain.ICourse#setEndDate((String date)
   */

  public void setEndDate(String ddmmyyyy) {
	  String day_month_year = ddmmyyyy;
	  endDate = DateUtils.convertFromDMY(day_month_year);
  }

  
  /**
   * @see edu.diary.domain.ICourse#getModules()
   */

  public Set<Module> getModules() {
    return modules;
  }

  /**
   * @see edu.diary.domain.ICourse#addModule(edu.diary.domain.module.BaseModule)
   */
  
  public Course addModule(Module aModule) {

    modules.add(aModule);
    return this;
  }


  /**
   * @see edu.diary.domain.ICourse#formatDate(java.util.Calendar)
   */

   @Override
  public int compareTo(Course other) {

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
