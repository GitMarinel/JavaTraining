package com.bpi.M6_Activity3;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", length = 50)
    private String courseName;

    @Column(name = "grade", length = 2)
    private Double grade;

    // Many courses belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false) // foreign key column
    private Student student;

    // Constructors
    public Course() {}

    public Course(String courseName, Double grade, Student student) {
        this.courseName = courseName;
        this.grade = grade;
        this.student = student;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Double getGrade() { return grade; }
    public void setGrade(Double grade) { this.grade = grade; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}