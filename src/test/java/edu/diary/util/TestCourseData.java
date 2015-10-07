package edu.diary.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Course;

public class TestCourseData {

	// name, startdate, enddate, isenabled, description
	
	public static final TestCourse JAVACOURSE = new TestCourse(1,
			"JAVA.Basics", (new GregorianCalendar(2015, 10, 07)), (
				new GregorianCalendar(2016, 02, 10)), true, "Java Core");
	
	public static final TestCourse DOTNETCOURSE = new TestCourse(2,
			"'DotNet for beginners", (new GregorianCalendar(2015, 10, 07)), (
				new GregorianCalendar(2016, 03, 20)), true, "Dot Net");

	
	
	public static final TestCourse CREATEDCOURSE = new TestCourse(3,
			"new Course", (new GregorianCalendar(2015, 10, 7)), (
				new GregorianCalendar(2016, 02, 07)), true, "new Course");
	
	public static final TestCourse PHPCOURSE = new TestCourse();

	
	
	
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
