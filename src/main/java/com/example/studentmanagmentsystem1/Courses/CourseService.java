package com.example.studentmanagmentsystem1.Courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    // Get course by ID
    public Course getCourseById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }
        
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }

    // Create a new course
    public Course createCourse(Course course) {
        try {
            if (course == null) {
                throw new IllegalArgumentException("Course data cannot be null");
            }

            // Validate required fields
            if (course.getCoursecode() == null || course.getCoursecode().trim().isEmpty()) {
                throw new IllegalArgumentException("Course code cannot be null or empty");
            }
            if (course.getCoursename() == null || course.getCoursename().trim().isEmpty()) {
                throw new IllegalArgumentException("Course name cannot be null or empty");
            }

            System.out.println("Received course: " + course);
            System.out.println("Saving course: " + course.getCoursename());

            // Save the received course directly (not a new empty one)
            Course savedCourse = courseRepository.save(course);
            System.out.println("Course saved successfully: " + savedCourse);

            return savedCourse;
        } catch (Exception e) {
            System.err.println("Error saving course: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to save course: " + e.getMessage(), e);
        }
    }

    // Update an existing course 
    public Course updateCourse(Long id, Course course) {
        if (id == null || course == null) {
            throw new IllegalArgumentException("Course ID or data cannot be null");
        }

        // Find existing course
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        // Validate required fields
        if (course.getCoursecode() == null || course.getCoursecode().trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (course.getCoursename() == null || course.getCoursename().trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        // Update the existing course with new values
        existingCourse.setCoursecode(course.getCoursecode());
        existingCourse.setCoursename(course.getCoursename());

        Course updatedCourse = courseRepository.save(existingCourse);
        System.out.println("Course updated successfully: " + updatedCourse);

        return updatedCourse;
    }

    // Delete a course 
    public void deleteCourse(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }

        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id: " + id);
        }

        try {
            courseRepository.deleteById(id);
            System.out.println("Course deleted successfully with id: " + id);
        } catch (Exception e) {
            System.err.println("Error deleting course: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to delete course: " + e.getMessage(), e);
        }
    }
}