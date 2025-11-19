package com.example.studentmanagmentsystem1.Courses;

import java.util.ArrayList;
import java.util.List;

import com.example.studentmanagmentsystem1.Students.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseid;

    private String coursecode;
    private String coursename;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {}

    public Long getId() { return courseid; }
    public void setId(Long courseid) { this.courseid = courseid; }

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
}