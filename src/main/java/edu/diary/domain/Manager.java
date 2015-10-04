package edu.diary.domain;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Main entity for project. Class stores info about courses and it's modules. Has methods to manage
 * courses and modules.
 * 
 * 
 * @author Roma
 */
@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager extends BaseName {

  @XmlElement(type = Course.class, name = "courses")
  private Set<ICourse> courses = new TreeSet<>();

  public Manager() {
  }

  public Manager(Integer id, String name) {
    super();
  }

  public Set<ICourse> getCourses() {
    return courses;
  }

  public Manager addCourse(ICourse aCourse) {
    courses.add(aCourse);
    return this;
  }

  public void showEnabledModules(ICourse aCourse, boolean variable) {
    Set<IModule> enabledModules = new TreeSet<>();
    for (IModule module : aCourse.getModules()) {
      if (module.isEnabled()) {
        enabledModules.add(module);
      } 
    }
    System.out.println(enabledModules);
  }

  public void showCoursesStartNextWeek(Set<ICourse> aCourses) {

    Calendar gCalendar = new GregorianCalendar();

    Set<ICourse> nextWeekCourses = new TreeSet<>();

    int today = gCalendar.get(Calendar.DAY_OF_MONTH);
    int month = gCalendar.get(Calendar.MONTH);
    int year = gCalendar.get(Calendar.YEAR);

    for (ICourse course : aCourses) {

      Calendar cal = new GregorianCalendar();
      cal = (Calendar) course.getStartDate();
      int startDate = cal.get(Calendar.DAY_OF_MONTH);
      int startMonth = cal.get(Calendar.MONTH);
      int startYear = cal.get(Calendar.YEAR);

      if (((startYear - year) == 0) && ((startMonth - month) == 0) && ((startDate - today) <= 7)) {
        nextWeekCourses.add(course);
        System.out.println(course);
      }
    }
    if (nextWeekCourses.isEmpty()) {
      System.out.println("No courses will start within next 7 days");
    }
  }


  
  @Override
  public String toString() {
    return "Manager{" 
                  + " name: " + super.getName() 
                  + ", Courses: " + getCourses() 
                  + "}";
  }
}
