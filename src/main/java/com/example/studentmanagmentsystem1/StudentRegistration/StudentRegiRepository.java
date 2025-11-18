package com.example.studentmanagmentsystem1.StudentRegistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegiRepository extends JpaRepository<StudentRegi, Long> {
}