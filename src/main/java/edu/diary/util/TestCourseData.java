package edu.diary.util;

import edu.diary.domain.Course;

public class TestCourseData {

	public static final TestCourse JAVACOURSE = new TestCourse("JAVA.Basics",
			"01.10.2015", "29.12.2015");

	public static final TestCourse DOTNETCOURSE = new TestCourse(
			"DotNet.Basics", "01.11.2015", "29.01.2016");

	static class TestCourse extends Course {

		public TestCourse(int id, String name, String startdate, String enddate) {
		}

		public TestCourse(String name, String startDate, String endDatess) {
		}
	}
}
