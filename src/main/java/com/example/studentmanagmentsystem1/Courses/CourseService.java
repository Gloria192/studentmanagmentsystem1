package com.example.studentmanagmentsystem1.Courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    public List<Course>getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }

        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    // Create a new course
    public Course createCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course data cannot be null");
        }

        validateCourse(course);

        return courseRepository.save(course);
    }

    // Update an existing course
    public Course updateCourse(Long id, Course course) {
        if (id == null || course == null) {
            throw new IllegalArgumentException("Course ID or data cannot be null");
        }

        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));    

        validateCourse(course);

        existingCourse.setCoursecode(course.getCoursecode());
        existingCourse.setCoursename(course.getCoursename());

        return courseRepository.save(existingCourse);
    }

    // Delete course
    public void deleteCourse(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }

        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id: " + id);
        }

        courseRepository.deleteById(id);
    }

    // Helper method to validate course data
    private void validateCourse(Course course) {
        if (course.getCoursecode() == null || course.getCoursecode().trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (course.getCoursename() == null || course.getCoursename().trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
    }
}