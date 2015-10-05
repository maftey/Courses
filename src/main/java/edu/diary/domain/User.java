
package edu.diary.domain;

import javax.xml.bind.annotation.XmlElement;
//TODO: add name, login ...
/**
 * @author Roma Stores information about users
 */

public class User /*extends BaseName*/ {

  @XmlElement(name = "lastname")
  private String lastName = null;

  /**
   * sets the score
   */
  private int userScore = 0;

  public User() {
  }

  public User(Integer id, String name, String lastName) {
    //super(id, name);
    this.lastName = lastName;
  }

  /**
   * sets user last name
   * 
   * @param lastName
   *          user last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * gets user lastname
   * 
   * @return user lastname
   */
  public String getLastName() {
    return lastName;
  }

  private int getUserScore() {
    return userScore;
  }

  private void setUserScore(int userScore) {
    this.userScore = userScore;
  }

  public String toString() {
    return "User{" 
        //    + "id= " + getId() 
        //+ ", name: " + getName() 
        + ", lastname: " + getLastName();
  }
}
