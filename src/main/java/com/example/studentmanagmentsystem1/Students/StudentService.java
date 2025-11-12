package com.example.studentmanagmentsystem1.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(StudentDto dto) {
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

    public Student updateStudent(Long id, StudentDto dto) {
        return studentRepository.findById(id).map(student -> {
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
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
