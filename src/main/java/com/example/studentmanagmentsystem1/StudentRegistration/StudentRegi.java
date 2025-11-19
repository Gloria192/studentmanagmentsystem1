package com.example.studentmanagmentsystem1.StudentRegistration;

import com.example.studentmanagmentsystem1.Courses.Course;
import com.example.studentmanagmentsystem1.Students.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_registrations")
public class StudentRegi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intake;
    private String registrationDate;
    private String status;

    // Relationship: Many registrations belong to one student

  @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-registration")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courses;

// @ManyToOne
// @JoinColumn(name = "course_id")
// private Course course;

// @ManyToOne
//     @JoinColumn(name = "student_id")
//     @JsonBackReference(value = "student-registration")
//     private Student student;

//     @ManyToOne
//     @JoinColumn(name = "course_id")
//     private Course course;

 
// private String coursecode;
// private String coursename;

public StudentRegi() {}

    public StudentRegi(String intake, String registrationDate, String status) {
        this.intake = intake;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) {
         this.id = id; 
        }

    public String getIntake() {
         return intake; 
        }
    public void setIntake(String intake) {
         this.intake = intake; 
        }

    public String getRegistrationDate() {
         return registrationDate;
         }
    public void setRegistrationDate(String registrationDate) { 
        this.registrationDate = registrationDate; 
    }

    public String getStatus() 
    { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public Student getStudent() {
        return student;
     }
    public void setStudent(Student student) {
         this.student = student; 
        }

    public Course getCourse() { 
        return courses;
    }
    public void setCourse(Course courses) {
         this.courses = courses; 
        }
    //     public String getCoursecode() {
    //         return coursecode;
    //     }
    //     public void setCoursecode(String coursecode) {
    //         this.coursecode = coursecode;
    //     }
    //     public String getCoursename() {
    //         return coursename;
    //     }
    //     public void setCoursename(String coursename) {
    //         this.coursename = coursename;
    // 

        }
    