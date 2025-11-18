package com.example.studentmanagmentsystem1.StudentRegistration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegiService {
    
    @Autowired
    private StudentRegiRepository studentRegiRepository;    

    // Get all registrations
    public List<StudentRegi> getAllRegistrations() {
        return studentRegiRepository.findAll();
    }
    
    // Save or update registration
    public StudentRegi saveRegistration(StudentRegi studentRegi) {
        return studentRegiRepository.save(studentRegi);
    }
    
    // Create new registration (same as save, but you might want separate logic)
    public StudentRegi createRegistration(StudentRegi studentRegi) {
        return studentRegiRepository.save(studentRegi);
    }
    
    // Update existing registration
    public StudentRegi updateRegistration(Long id, StudentRegi studentRegi) {
        // Check if the registration exists
        Optional<StudentRegi> existingRegi = studentRegiRepository.findById(id);
        if (existingRegi.isPresent()) {
            StudentRegi regiToUpdate = existingRegi.get();
            regiToUpdate.setIntake(studentRegi.getIntake());
            regiToUpdate.setRegistrationDate(studentRegi.getRegistrationDate());
            regiToUpdate.setStatus(studentRegi.getStatus());
            return studentRegiRepository.save(regiToUpdate);
        } else {
            throw new RuntimeException("Registration not found with id: " + id);
        }
    }
    
    // Delete registration
    public void deleteRegistration(Long id) {
        if (studentRegiRepository.existsById(id)) {
            studentRegiRepository.deleteById(id);
        } else {
            throw new RuntimeException("Registration not found with id: " + id);
        }
    }
    
    // Get registration by ID
    public Optional<StudentRegi> getRegistrationById(Long id) {
        return studentRegiRepository.findById(id);
    }
    
    // Check if registration exists
    public boolean registrationExists(Long id) {
        return studentRegiRepository.existsById(id);
    }
}