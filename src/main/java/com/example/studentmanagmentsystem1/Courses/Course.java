package com.example.studentmanagmentsystem1.Courses;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String coursecode;
    private String coursename;
     
    
    public String getCoursecode() {
        return coursecode;
    }
    public String getCoursename() {
        return coursename;
    }
    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

}