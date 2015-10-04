
package edu.diary.domain;

public interface IModule {

  /**
   * method sets id
   * 
   * @param is
   *          a id for all inherited classes
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
   * returns enabled or disabled module
   * 
   * @return true/false
   */
  boolean isEnabled();

  /**
   * sets course to be enabled or disabled
   * 
   * @param boolean sets enable/disable module
   * @return this
   */
  void setEnabled(boolean isEnabled);

  /**
   * 
   * @param userScore
   * @return checks if module passed or failed
   */
  void checkPassed(int userScore);

  boolean getPassed();

  /**
   * metod sets threshold value to pass module
   * 
   * @return the passingScore
   */
  void setPassingScore(int passingScore);

  /**
   * metod gets threshold value to pass module
   * 
   * @return the passingScore
   */
  int getPassingScore();

  int compareTo(IModule other);


}