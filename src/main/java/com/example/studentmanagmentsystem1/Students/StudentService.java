package com.example.studentmanagmentsystem1.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get one student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Create a new student
    public Student createStudent(StudentDto dto) {

        if (dto == null) {
            throw new RuntimeException("Student data cannot be null");
        }

        Student student = new Student(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getAddress(),
                dto.getGender(),
                dto.getDob(),
                dto.getMotherName(),
                dto.getFatherName(),
                dto.getMotherPhone(),
                dto.getFatherPhone(),
                dto.getGuardianName(),
                dto.getGuardianPhone(),
                dto.getGuardianAddress()
        );

        return studentRepository.save(student);
    }

    // Update existing student
    public Student updateStudent(Long id, StudentDto dto) {

        if (dto == null) {
            throw new RuntimeException("Student data cannot be null");
        }

        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(dto.getFirstName());
                    student.setLastName(dto.getLastName());
                    student.setEmail(dto.getEmail());
                    student.setPhone(dto.getPhone());
                    student.setAddress(dto.getAddress());
                    student.setGender(dto.getGender());
                    student.setDob(dto.getDob());
                    student.setMotherName(dto.getMotherName());
                    student.setFatherName(dto.getFatherName());
                    student.setMotherPhone(dto.getMotherPhone());
                    student.setFatherPhone(dto.getFatherPhone());
                    student.setGuardianName(dto.getGuardianName());
                    student.setGuardianPhone(dto.getGuardianPhone());
                    student.setGuardianAddress(dto.getGuardianAddress());

                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}
