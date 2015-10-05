package edu.diary.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;

/**
 * Class represents a <code>name</code> and is a superClass for all entities.
 * 
 */
public abstract class BaseName extends Base {
  
  /**
   * @param  name for all inherited classes
   */
  private String name;
  private Calendar startDate = new GregorianCalendar();
  private Calendar endDate = new GregorianCalendar();
  private String description;
  /**
   * flag. shows enabled/disabled module
   */
  private boolean enabled = true;

  /**
   * @param  is a name for all inherited classes
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return returns<code>name</code> of entity
   */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
  
  public Calendar getStartDate() {
    return startDate;
  }
  
  public Calendar getEndDate() {
    return endDate;
  }
  
  public void getFEndDate() {
    System.out.println(formatDate(startDate));
  }

  public void setStartDate(int day, int month, int year) {
//    startDate = new GregorianCalendar(year, month, day);
  
    startDate.set(Calendar.DAY_OF_MONTH, day);
    startDate.set(Calendar.MONTH, month - 1);
    startDate.set(Calendar.YEAR, year);
    
  }

  public void setEndDate(int day, int month, int year) {

    endDate.set(Calendar.DAY_OF_MONTH, day);
    endDate.set(Calendar.MONTH, month - 1);
    endDate.set(Calendar.YEAR, year);
  }
  
  public void setStartDate(Calendar startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }
  
  public String formatDate(Calendar unformattedDate) {
    Date date = unformattedDate.getTime();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    return (String) dateFormat.format(date);
  }
  
  /* 
   * @see edu.diary.domain.ModuleInterface#isEnabled()
   */
  public boolean isEnabled() {
    return enabled;
  }
  
  public boolean getEnabled() {
    return enabled;
  }
  
  /* 
   * @see edu.diary.domain.ModuleInterface#setEnabled(boolean)
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  

}
