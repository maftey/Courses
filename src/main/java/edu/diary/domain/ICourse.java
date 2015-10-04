package edu.diary.domain;

import java.util.Calendar;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Course.class, name = "Course") })
public interface ICourse {

  /**
   * method sets id
   * 
   * @param id
   */
  void setId(Integer id);

  /**
   * method returns int id
   * 
   * @return id of entity
   */
  Integer getId();

  void setName(String name);

  String getName();

  /**
   * @return calendar
   */
  Calendar getStartDate();

  /**
   * sets start date course
   * 
   * @param day
   *          day(1-31)
   * @param month
   *          month (0-11)
   * @param year
   *          yyyy
   */
  void setStartDate(int day, int month, int year);

  /**
   * 
   * @return course end date
   */
  Calendar getEndDate();

  /**
   * sets course end date
   * 
   * 
   * @param day
   *          day(1-31)
   * @param month
   *          month (0-11)
   * @param year
   *          year yyyy
   */
  void setEndDate(int day, int month, int year);

  /**
   * @return set of course modules
   */
  Set<IModule> getModules();

  /**
   * @return ads module to module set
   */
  ICourse addModule(IModule module);
  
  /**
   * 
   * @param unformattedDate
   *          type Calendar is being formatted for pretty output
   * @return formatted date
   */
  String formatDate(Calendar unformattedDate);

  int compareTo(ICourse other);
}