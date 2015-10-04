package edu.diary.domain;

/**
 * Class represents a <code>name</code> and is a superClass for all entities.
 * @author Roman Romaniuk 
 */
public class BaseName extends Base {
  
  /**
   * @param  name for all inherited classes
   */
  private String name;

  public BaseName() {
  }

  public BaseName(Integer id, String name) {
    super(id);
    this.name = name;
  }

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

}
