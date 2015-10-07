package edu.diary.util;

import static edu.diary.util.TestModuleData.JAVACOURSE;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Course;
import edu.diary.domain.Module;

public class TestModuleData {

	// name, startdate, enddate, isenabled, description

	public static final TestCourse JAVACOURSE = new TestCourse(1,
			"JAVA.Basics", (new GregorianCalendar(2015, 10, 07)),
			(new GregorianCalendar(2016, 02, 10)), true, "Java Core");

	public static final Course DOTNETCOURSE = new TestCourse(2,
			"'DotNet for beginners", (new GregorianCalendar(2015, 10, 07)),
			(new GregorianCalendar(2016, 03, 20)), true, "Dot Net");

	public static final Course CREATEDCOURSE = new TestCourse(3, "new Course",
			(new GregorianCalendar(2015, 10, 7)), (new GregorianCalendar(
					2016, 02, 07)), true, "new Course");

//	 (name, startdate, enddate, description, isenabled, course_id, test_id)
	public static final Module JAVAMODULE1 = new TestModule(1, "java module1",
			(new GregorianCalendar(2015, 10, 07)), (new GregorianCalendar(
					2015, 10, 10)), "Introducing", true, 1, 1);
//	 (name, startdate, enddate, description, isenabled, course_id, test_id)
	public static final Module JAVAMODULE1 = new TestModule(1, "java module1",
			(new GregorianCalendar(2015, 10, 07)), (new GregorianCalendar(
					2015, 10, 10)), "Introducing", true, 1, 1);
//	 (name, startdate, enddate, description, isenabled, course_id, test_id)
	public static final Module JAVAMODULE1 = new TestModule(1, "java module1",
			(new GregorianCalendar(2015, 10, 07)), (new GregorianCalendar(
					2015, 10, 10)), "Introducing", true, 1, 1);
	
	public static class TestModule extends Module {
		public TestModule() {
		}

		public TestModule copyOfModule() {
			return new TestModule(this);
		}

		public TestModule(int id, String name, Calendar startDate,
				Calendar endDate, boolean isEnabled, String description) {
			this.setId(id);
			this.setName(name);
			this.setStartDate(startDate);
			this.setEndDate(endDate);
			this.setEnabled(isEnabled);
			this.setDescription(description);
		}

		public TestModule(TestModule testModule) {
			this(testModule.getId(), testModule.getName(), testModule
					.getStartDate(), testModule.getEndDate(), testModule
					.getEnabled(), testModule.getDescription());
		}

		public TestModule(Module module) {
			this(module.getId(), module.getName(), module.getStartDate(),
					module.getEndDate(), module.getEnabled(), 
					module.getDescription());
		}

		public TestModule(int i, String string,
				GregorianCalendar startDate,
				GregorianCalendar endDate, String description,
				boolean isEnabled, int course_id, int test_id) {
			// TODO Auto-generated constructor stub
		}
	}

}
