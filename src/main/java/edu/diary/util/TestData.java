import edu.diary.domain.Base;
import edu.diary.domain.Course;
import edu.diary.util.TablesCreator;


public class TestData extends Course{
	 
	 final  TestCourse COURSE = new TestCourse(Base.START_SEQ, "JAVA.Basics", "12.4/2016","04.05.2016");
//	public static   TestCourse COURSE = new TestCourse();
//	COURSE.setId(1);
//    course1.setName("JAVA.Basics");
//    course1.setStartDate("12.4/2016");
//    course1.setEndDate("04.05.2016");
    	
	  public  class TestCourse extends Course{

		public TestCourse(int id, String name, String startdate, String enddate) {
			// TODO Auto-generated constructor stub
		}

//		public TestCourse(int id, String name, String startdate, String enddate) {
//			this(startSeq,  string, string2,  string3);
//		}
		
				
		
	}
	
	  
	
	
}
