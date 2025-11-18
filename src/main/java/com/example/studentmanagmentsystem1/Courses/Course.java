package com.example.studentmanagmentsystem1.Courses;

import java.util.List;

// import com.example.studentmanagmentsystem1.StudentRegistration.StudentRegi;
import com.example.studentmanagmentsystem1.Students.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coursecode;
    private String coursename;

  @ManyToMany(mappedBy = "courses")
private List<Student> students;


    // public List<Long>course_id;

    public Course() {}

    public Long getId() { return id; }
    public void setId(Long id) { 
        this.id = id; }

    public String getCoursecode() { return coursecode; }
    public void setCoursecode(String coursecode) { this.coursecode = coursecode; }

    public String getCoursename() { return coursename; }
    public void setCoursename(String coursename) { this.coursename = coursename; }


    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    
//     public List<StudentRegi> getRegistrations() {
//         return registrations;
//     }
//     public void setRegistrations(List<StudentRegi> registrations) {
//         this.registrations = registrations;
//     }
 }