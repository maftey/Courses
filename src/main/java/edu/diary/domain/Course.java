package edu.diary.domain;

import java.util.Set;
import java.util.TreeSet;

<<<<<<< HEAD
=======
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import edu.diary.util.DateUtils;

>>>>>>> 68f48dec2bcc935a0156c048061131b0e56044f2

/**
 * @author Roma Representation of course and modules.
 */
<<<<<<< HEAD
//TODO:Comparable move in base
public class Course extends AbstractUnit implements Comparable<Course> {
  

  
  //TODO: maybe List? or something with order
  private Set<Module> modules = new TreeSet<>();
  
  public Set<Module> getModules() {
    return modules;
  }

  public Course addModule(Module aModule) {
=======
public class Course extends BaseName implements Comparable<Course>{
  

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

  public Set<IModule> getModules() {
    return modules;
  }

  /**
   * @see edu.diary.domain.ICourse#addModule(edu.diary.domain.module.BaseModule)
   */
  
  public Course addModule(IModule aModule) {
>>>>>>> 68f48dec2bcc935a0156c048061131b0e56044f2
    modules.add(aModule);
    return this;
  }

<<<<<<< HEAD
  public int compareTo(Course other) {//ToDO maybe move to Base
=======
  /**
   * @see edu.diary.domain.ICourse#formatDate(java.util.Calendar)
   */

  
  public String formatDate(Calendar unformattedDate) {
    Date date = unformattedDate.getTime();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    return (String) dateFormat.format(date);
  }
  
  @Override
  public int compareTo(Course other) {
>>>>>>> 68f48dec2bcc935a0156c048061131b0e56044f2
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
