package m5_activity3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	//Initialize variables
	private static int choice;
	private static Courses courses;
	private static Student student;
	
	private static final Scanner scn = new Scanner(System.in);
	
	//SQL
	static Connection connection = null;
	static String sql = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String url = "jdbc:postgresql://localhost:5432/training_db";
	    String username = "gstmdeleon";
	    String password = "Welcome5%";
	    

	    try {
	         Class.forName("org.postgresql.Driver");

	         connection = DriverManager.getConnection(url, username, password);

	         System.out.println("Connected successfully!");

	         
	         
	         Run();
	         
	         connection.close(); 
	     } catch (SQLException e) {
	         System.out.println("Connection failed: " + e.getMessage());

	     } catch (ClassNotFoundException e) {
	         System.out.println("PostgreSQL Driver not found: " + e.getMessage());
	     }


	}
	
	public static void Run() 
	{

        while (true) {
            // Display menu
            menu();

            try {
                choice = scn.nextInt(); 

                // Validate range
                if (choice < 0 || choice > 4) {
                    System.out.print("❗! Invalid choice. Please enter a number between 0 and 4.");
                    continue; // prompt again
                }

                // Handle valid choices
                switch (choice) {
                    case 1:
                        student = Enrollment.addStudent();
                        //Insert student into database

						String insetStudent = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
						try (PreparedStatement ps = connection.prepareStatement(insetStudent)) {
						    ps.setString(1, student.getName());
						    ps.setInt(2, student.getAge());
						    ps.setString(3, student.getEmail());
						    ps.executeUpdate();
						    System.out.println("Student added successfully!");
						} catch (SQLException ex) {
						    System.out.println("Error encountered while inserting data: " + ex.getMessage());
						}
                        break;
                    case 2:
                    	courses = Enrollment.addCourse();
                    	//Check if the student is existing
                    	if(studentExists(connection, courses.getStudent_id())) {
                    		//Insert course into database
    						String insertCourse = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?)";
    						try (PreparedStatement ps = connection.prepareStatement(insertCourse)) {
    						    ps.setInt(1, courses.getStudent_id());
    						    ps.setString(2, courses.getCourse_name());
    						    ps.setDouble(3, courses.getGrade());
    						    ps.executeUpdate();
    						    System.out.println("Course added successfully!");
    						} catch (SQLException ex) {
    						    System.out.println("Error encountered while inserting data: " + ex.getMessage());
    						}
                    	}else {
                    		System.out.println("Student does not exist");
                    	}
                        break;
                    case 3:
                    	showStudents(connection);
                        break;
                    case 4:
                    	showCourses(connection);
                        break;
                    case 0:
                        System.out.println("Exiting... Goodbye!");
                        scn.close();
                        return; // exit main
                }

            } catch (InputMismatchException e) {
                // Handles non-integer input (e.g., 'a', '3.14', '#', etc.)
                System.out.print("!! Invalid input. Please enter an integer between 0 and 4.");
            }
            
        }
        
	}
	
	private static void menu() {
		System.out.println("");
	    System.out.println("===== STUDENT COURSE MANAGEMENT =====");
	    System.out.println("1. Add Student");
	    System.out.println("2. Add Curse");
	    System.out.println("3. Show Students");
	    System.out.println("4. Show Courses");
	    System.out.println("0. Exit");
	    System.out.print("Choose an option: ");
	}
	

	private static boolean studentExists(Connection connection, int studentId) {
	    final String sql = "SELECT 1 FROM students WHERE id = ? LIMIT 1";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setInt(1, studentId);
	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next(); // true if a row exists
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error checking student existence: " + ex.getMessage());
	        return false; // or rethrow, depending on your error handling
	    }
	}
	


	public static void showStudents(Connection connection) {
	    String selectStudents = "SELECT id, name, age, email FROM students ORDER BY id";
	
	    // Adjust these widths to fit your data
	    final int W_ID = 5, W_NAME = 20, W_AGE = 5, W_EMAIL = 35;
	
	    String header = String.format("| %-" + W_ID + "s | %-" + W_NAME + "s | %-" + W_AGE + "s | %-" + W_EMAIL + "s |",
	            "ID", "Name", "Age", "Email");
	    String line = "+" + "-".repeat(W_ID + 2) + "+" + "-".repeat(W_NAME + 2) + "+" + "-".repeat(W_AGE + 2) + "+"
	            + "-".repeat(W_EMAIL + 2) + "+";
	
	    try (Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery(selectStudents)) {
	
	        System.out.println(line);
	        System.out.println(header);
	        System.out.println(line);
	
	        boolean hasData = false;
	        while (rs.next()) {
	            hasData = true;
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	
	            // Truncate long text to fit the column width
	            name = fit(name, W_NAME);
	            email = fit(email, W_EMAIL);
	
	            String row = String.format("| %-" + W_ID + "d | %-" + W_NAME + "s | %-" + W_AGE + "d | %-" + W_EMAIL + "s |",
	                    id, name, age, email);
	            System.out.println(row);
	        }
	
	        if (!hasData) {
	            System.out.println("| " + center("No students found", W_ID + W_NAME + W_AGE + W_EMAIL + 9) + " |");
	        }
	
	        System.out.println(line);
	
	    } catch (SQLException ex) {
	        System.out.println("Error while retrieving students: " + ex.getMessage());
	    }
	}
	

	// ===== Show all courses with auto-sized columns =====
	public static void showCourses(Connection connection) {
	
	    String selectCourses = "SELECT id, student_id, course_name, grade FROM courses ORDER BY id";
	
	    List<String[]> rows = new ArrayList<>();
	    String[] headers = {"ID", "Student ID", "Course Name", "Grade"};
	
	    try (Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery(selectCourses)) {
	
	        // Compute max width per column (start with header widths)
	        int[] widths = Arrays.stream(headers).mapToInt(String::length).toArray();
	
	        while (rs.next()) {
	            String id         = String.valueOf(rs.getInt("id"));
	            String studentId  = String.valueOf(rs.getInt("student_id"));
	            String courseName = nullToEmpty(rs.getString("course_name"));
	
	            // Use getDouble as you requested; handle NULL as blank.
	            double gradeVal = rs.getDouble("grade");
	            String grade = rs.wasNull() ? "" : String.format("%.2f", gradeVal);
	
	            String[] row = { id, studentId, courseName, grade };
	            rows.add(row);
	
	            for (int i = 0; i < row.length; i++) {
	                widths[i] = Math.max(widths[i], row[i] != null ? row[i].length() : 0);
	            }
	        }
	
	        if (rows.isEmpty()) {
	            widths = Arrays.stream(headers).mapToInt(String::length).toArray();
	        }
	
	        String line = buildBorder(widths);
	        System.out.println(line);
	        System.out.println(buildRow(headers, widths));
	        System.out.println(line);
	
	        if (rows.isEmpty()) {
	            System.out.println(buildRow(new String[]{"No courses found", "", "", ""}, widths));
	        } else {
	            for (String[] r : rows) {
	                System.out.println(buildRow(r, widths));
	            }
	        }
	        System.out.println(line);
	
	    } catch (SQLException ex) {
	        System.out.println("Error while retrieving courses: " + ex.getMessage());
	    }
	}


	
	// Helpers
	private static String fit(String s, int width) {
	    if (s == null) s = "";
	    if (s.length() <= width) return s;
	    if (width <= 3) return s.substring(0, Math.max(0, width));
	    return s.substring(0, width - 3) + "...";
	}
	private static String center(String s, int width) {
	    if (s.length() >= width) return s.substring(0, width);
	    int pad = width - s.length();
	    int left = pad / 2, right = pad - left;
	    return " ".repeat(left) + s + " ".repeat(right);
	}

	private static String nullToEmpty(String s) {
	    return s == null ? "" : s;
	}
	private static String buildBorder(int[] widths) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+");
	    for (int w : widths) {
	        sb.append("-".repeat(w + 2)).append("+");
	    }
	    return sb.toString();
	}
	private static String buildRow(String[] cols, int[] widths) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("|");
	    for (int i = 0; i < widths.length; i++) {
	        String v = (i < cols.length && cols[i] != null) ? cols[i] : "";
	        sb.append(" ").append(padRight(v, widths[i])).append(" |");
	    }
	    return sb.toString();
	}
	private static String padRight(String s, int width) {
	    if (s.length() >= width) return s;
	    return s + " ".repeat(width - s.length());
	}



}
