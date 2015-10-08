package edu.diary.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Module;
import edu.diary.util.TestCourseData.TestCourse;

public class TestModuleData {

	// (name, startdate, enddate, description, isenabled, course_id, test_id)
	public static final Module JAVAMODULE1 = new TestModule(1, "java module1",
			(new GregorianCalendar(2015, 10, 07)), (new GregorianCalendar(2015,
					10, 10)), "Introducing", true, 1, 1);

	public static final Module JAVAMODULE2 = new TestModule(2, "java module2",
			(new GregorianCalendar(2015, 10, 11)), (new GregorianCalendar(2015,
					10, 14)), "Objects and classes", true, 1, 1);

	public static final Module JAVAMODULE3 = new TestModule(3, "java module3",
			(new GregorianCalendar(2015, 10, 15)), (new GregorianCalendar(2015,
					10, 18)), "Inheritance", true, 1, 1);

	public static final Module JAVAMODULE4 = new TestModule(4, "java module4",
			(new GregorianCalendar(2015, 10, 21)), (new GregorianCalendar(2015,
					10, 24)), "Interfaces and nested classes", true, 1, 1);

	public static final Module JAVAMODULE5 = new TestModule(5, "java module5",
			(new GregorianCalendar(2015, 10, 25)), (new GregorianCalendar(2015,
					10, 28)), "Generics", true, 1, 1);

	public static final Module DOTNETMODULE1 = new TestModule(6,
			"dotNet module1", (new GregorianCalendar(2015, 10, 07)),
			(new GregorianCalendar(2015, 10, 10)), "Introducing to .Net", true,
			1, 1);

	public static final Module DOTNETMODULE2 = new TestModule(7,
			"dotNet module2S", (new GregorianCalendar(2015, 10, 07)),
			(new GregorianCalendar(2015, 10, 10)), "Collections", true, 1, 1);

	public static final Module CREATEDMODULE = new TestModule(8, "new Module",
			(new GregorianCalendar(2016, 10, 07)), (new GregorianCalendar(2016,
					10, 10)), "new description", true, 1, 1);

	public static class TestModule extends Module {
		public TestModule() {
		}

		public TestModule(int id, String name, Calendar startDate,
				Calendar endDate, String description, boolean isEnabled,
				int courseId, int testId) {
			this.setId(id);
			this.setName(name);
			this.setStartDate(startDate);
			this.setEndDate(endDate);
			this.setDescription(description);
			this.setEnabled(isEnabled);
			this.setCourseId(courseId);
			this.setCourseId(courseId);
			this.setTestId(testId);
		}

		public TestModule(Module module) {
			this(module.getId(), module.getName(), module.getStartDate(),
					module.getEndDate(), module.getDescription(), module
							.getEnabled(), module.getCourseId(), module
							.getTestId());
		}
	}
}
