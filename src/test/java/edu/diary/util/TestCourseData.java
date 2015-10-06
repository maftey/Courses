package edu.diary.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Course;

public class TestCourseData {
	
	
	
	

	public static final Course testJavaCourse(){
		Course javaCourse = new Course();
		javaCourse.setName("JAVA.NEW");
		javaCourse.setStartDate(01, 10, 2016);
		javaCourse.setEndDate(29, 12, 2016);
		javaCourse.setEnabled(true);
		javaCourse.setDescription("sdwehfuiwhfiuhwefuihweuifi");
		return javaCourse;
	}
				
	public static final Course testDotNetCourse(){
		Course javaCourse = new Course();
		javaCourse.setName("DotNet.NEW");
		javaCourse.setStartDate(01, 10, 2016);
		javaCourse.setEndDate(29, 12, 2016);
		javaCourse.setEnabled(false);
		javaCourse.setDescription("new course");
		return javaCourse;
	}

	
	//	name, startdate, enddate, isenabled, description
	public static final TestCourse DOTNETCOURSE = new TestCourse(
			"DotNet.NEW", (null), (null), false, "new course");
		
	
	public static final TestCourse JAVACOURSE = new TestCourse(
			"JAVA.NEW",(null), (null), false, "new course");
	

	static class TestCourse extends Course {
		
		
		public TestCourse(String name, Calendar date,
				Calendar Calendar, boolean enabled, String description) {
			
		}
//		public TestCourse(String name, Calendar startDate, Calendar endDate, String description) {
//            this(name, startDate, endDate, description);
//        }
		
	}
}
