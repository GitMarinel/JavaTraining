package m5_activity3;

import java.util.Scanner;

public class Enrollment {
	private static Scanner scn = new Scanner(System.in);
	
	public static Student addStudent() {
		String name;
		int age;
		String email;
		
		System.out.print("Enter name: ");
		 name = scn.next().trim();
		
		 while (true) {
		            System.out.print("Enter age: ");
		            String raw = scn.next().trim();
		            try {
		                age = Integer.parseInt(raw);
		                break;
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid age. Please enter a number : " + e.getMessage());
		            }
		        }

		System.out.print("Enter email: ");
		email = scn.next().trim();
		
		Student student = new Student(name, age, email);
        return student;

	}
	public static Courses addCourse() {
		int student_id;
		String course_name;
		double grade;
		
		while (true) {
		      System.out.print("Enter student id: ");
		      String raw = scn.next().trim();
		      try {
		           student_id = Integer.parseInt(raw);
		           break;
		          } 
		      catch (NumberFormatException e) {
		            System.out.println("Invalid student Id. Please enter a number : " + e.getMessage());
		          }
		}

		System.out.print("Enter course name: ");
		course_name = scn.next().trim();
		
		while (true) {
		      System.out.print("Enter grade: ");
		      String raw = scn.next().trim();
		      try {
		    	  grade = Double.parseDouble(raw);
		           break;
		          } 
		      catch (NumberFormatException e) {
		            System.out.println("Invalid grade. Please enter a number : " + e.getMessage());
		          }
		}
		
		Courses courses = new Courses(student_id, course_name, grade);
        return courses;

	}

}
