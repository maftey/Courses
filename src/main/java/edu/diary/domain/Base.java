package edu.diary.domain;

/**
 * @author Roman Romaniuk Class is a superClass for all entities.
 */

public abstract class Base {

  /**
   *  used for start sequence for entities id's (for test purposes only)
   */
  public static final int START_SEQ = 1;//TODO: for test? delete

  /**
   * id of all inherited classes
   */
  private Integer id;//TODO: why not just int?
  
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
  
  public boolean isNew (){
	  
	return this.id==null;
	 
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
