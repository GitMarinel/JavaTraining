package m5_activity3;

public class Courses {
	
	private int student_id;
	private String course_name;
	private double grade;
	
	public Courses() {	}
	
	public Courses(int student_id, String course_name, double grade) {
		this.setStudent_id(student_id);
		this.setCourse_name(course_name);
		this.setGrade(grade);
	}
	
	//Get
		public int getStudent_id()
		{
			return this.student_id;
		}	
		public String getCourse_name()
		{
			return this.course_name;
		}	
		public double getGrade()
		{
			return this.grade;
		}	
		
		//Set
		public void setStudent_id(int student_id) 
		{
			this.student_id = student_id;
		}
		public void setCourse_name(String course_name) 
		{
			this.course_name = course_name;
		}
		public void setGrade(double grade) 
		{
			this.grade = grade;
		}
	    @Override
	    public String toString() {
	        return "Courses{student_id='" + student_id + "', course_name=" + course_name + ", grade='" + grade + "'}";
	    }
	
}
