package edu.diary.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Course;

public class TestCourseData {

	// name, startdate, enddate, isenabled, description
	
	public static final TestCourse JAVACOURSE = new TestCourse(1,
			"JAVA.Basics", (new GregorianCalendar(7, 10, 2015)), (
				new GregorianCalendar(10, 02, 2016)), true, "Java Core");
	
	public static final TestCourse DOTNETCOURSE = new TestCourse(2,
			"'DotNet for beginners", (new GregorianCalendar(07, 10, 2015)), (
				new GregorianCalendar(20, 03, 2016)), true, "Dot Net");

	
	
	public static final TestCourse CREATEDCOURSE = new TestCourse(3,
			"new Course", (new GregorianCalendar(7, 10, 2015)), (
				new GregorianCalendar(10, 02, 2016)), true, "new Course");
	
	public static final TestCourse PHPCOURSE = new TestCourse();

	public static Course getCreated() {
        return new Course();
    }
	public static Course getUpdated() {
        Course updated = new TestCourse(JAVACOURSE);
        updated.setDescription("Updated from TestCourseData");
        return updated;
    }
	
	
	
	public static class TestCourse extends Course {
		public TestCourse() {
			}

		public TestCourse copyOfCourse() {
			return new TestCourse(this);
		}

		public TestCourse(int id, String name, Calendar startDate, Calendar endDate,
				boolean isEnabled, String description) {
			this.setId(id);
			this.setName(name);
			this.setStartDate(startDate);
			this.setEndDate(endDate);
			this.setEnabled(isEnabled);
			this.setDescription(description);
		}

		public TestCourse(TestCourse testCourse) {
			this(testCourse.getId(),testCourse.getName(), testCourse.getStartDate(), 
					testCourse.getEndDate(), testCourse.getEnabled(), 
					testCourse.getDescription());
		}

	}

}
