package edu.diary.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Roman Romaniuk Class is a superClass for all entities.
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class Base {

  /**
   *  used for start sequence for entities id's (for test purposes only)
   */
  @XmlTransient
  public static final int START_SEQ = 1;

  /**
   * id of all inherited classes
   */
   @XmlAttribute
  private Integer id;

  public Base() {
  }

 
  public Base(Integer id) {
    this.id = id;
  }
  
  /**
   * method sets id
   * @param  is a id for all inherited classes
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * method returns int id
   * @return id of entity
   */
  public Integer getId() {
    return id;
  }
  
  public int isNew (){
	  if(this.id==null){
		  return 0;
	  }
	return 1;
	 
}

  @Override
  public boolean equals(Object obj) {

    if (obj == null)  {
      return false;
    }
    if (!(obj instanceof Base)) {
      return false;
    }
    Base other = (Base) obj;
    return this.id.equals(other.id);
  }

  @Override
  public int hashCode() {
    return (id == null) ? 0 : id;
  }

  // @Override
  // public String toString(){
  // return getClass().getName() + " [id= "+ id + ", ";
  // }
}
