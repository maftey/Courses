
package edu.diary.domain;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Roma on 22.09.2015.
 */
public class Diary {

  public static void main(String[] args) {

    Manager man = new Manager();
    man.setName("MANAGER");
    
    Course course1 = new Course();
    course1.setId(1);
    course1.setName("JAVA.Basics");
    course1.setStartDate(7, 10, 2015);
    course1.setEndDate(10, 2, 2016);
    course1.addModule(new Module(1, "Introducing", true, 50));
    course1.addModule(new Module(2, "Objects and classes", true, 95));
    course1.addModule(new Module(3, "Inheritance", false, 75));
    course1.addModule(new Module(4, "Interfaces and nested classes", false, 75));
    course1.addModule(new Module(5, "Generics", false, 75 ));
    
    Course course2 = new Course();
    course2.setId(2);
    course2.setName("DotNet for beginners");
    course2.setStartDate(1,10,2015);
    course2.setEndDate( 20,3, 2016);
    course2.addModule(new Module(1, "Introducing to .Net",true, 50));
    course2.addModule(new Module(2, "Collections", false, 75));
    man.addCourse(course1).addCourse(course2);
}
  }


