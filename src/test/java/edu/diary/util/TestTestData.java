package edu.diary.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.diary.domain.Tests;


public class TestTestData {

	// (name, startdate, enddate, isenabled, passedscore)
	public static final Tests JAVATEST1 = new TestTest(1, "test1",
			(new GregorianCalendar(2016, 10, 10)), (new GregorianCalendar(2016,
					10, 10)), true, 50);

	public static final Tests JAVATEST2 = new TestTest(2, "test2",
			(new GregorianCalendar(2016, 10, 14)), (new GregorianCalendar(2016,
					10, 14)), true, 75);

	public static final Tests JAVATEST3 = new TestTest(3, "test3",
			(new GregorianCalendar(2016, 10, 18)), (new GregorianCalendar(2016,
					02, 18)), true, 50);

	public static final Tests JAVATEST4 = new TestTest(4, "test4",
			(new GregorianCalendar(2016, 02, 22)), (new GregorianCalendar(2016,
					10, 22)), true, 50);

	public static final Tests JAVATEST5 = new TestTest(5, "test5",
			(new GregorianCalendar(2016, 02, 26)), (new GregorianCalendar(2016,
					10, 26)), true, 50);

	public static final Tests DOTNETTEST1 = new TestTest(6, "test6",
			(new GregorianCalendar(2016, 02, 30)), (new GregorianCalendar(2016,
					10, 30)), true, 50);

	public static final Tests DOTNETTEST2 = new TestTest(7, "test7",
			(new GregorianCalendar(2016, 02, 10)), (new GregorianCalendar(2016,
					10, 10)), true, 50);

	public static final Tests CREATEDTEST = new TestTest(8, "new Test",
			(new GregorianCalendar(2016, 10, 07)), (new GregorianCalendar(2016,
					10, 10)), true, 100);

	public static class TestTest extends Tests {
		public TestTest() {
		}

		public TestTest(int id, String name, Calendar startDate,
				Calendar endDate, boolean isEnabled, int passedScore) {
			this.setId(id);
			this.setName(name);
			this.setStartDate(startDate);
			this.setEndDate(endDate);

			this.setEnabled(isEnabled);
			this.setPassedScore(passedScore);
		}

		public TestTest(Tests test) {
			this(test.getId(), test.getName(), test.getStartDate(), test
					.getEndDate(), test.getEnabled(), test.getPassedScore());
		}
	}

}
