package com.example.studentmanagmentsystem1.StudentRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student_registrations")
@CrossOrigin(origins = "*")
public class StudentRegiController {

    @Autowired
    private StudentRegiService studentRegiService;

    // Get all registrations
    @GetMapping
    public ResponseEntity<List<StudentRegi>> getAllRegistrations() {
        try {
            List<StudentRegi> registrations = studentRegiService.getAllRegistrations();
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentRegi> getRegistrationById(@PathVariable Long id) {
        try {
            Optional<StudentRegi> registration = studentRegiService.getRegistrationById(id);
            if (registration.isPresent()) {
                return new ResponseEntity<>(registration.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create new registration
    @PostMapping("/create")
    public ResponseEntity<StudentRegi> createRegistration(@RequestBody StudentRegi studentRegi) {
        try {
            StudentRegi newRegistration = studentRegiService.createRegistration(studentRegi);
            return new ResponseEntity<>(newRegistration, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update registration
    @PutMapping("/{id}")
    public ResponseEntity<StudentRegi> updateRegistration(@PathVariable Long id, @RequestBody StudentRegi studentRegi) {
        try {
            StudentRegi updatedRegistration = studentRegiService.updateRegistration(id, studentRegi);
            return new ResponseEntity<>(updatedRegistration, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete registration
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRegistration(@PathVariable Long id) {
        try {
            studentRegiService.deleteRegistration(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}