package com.example.studentmanagmentsystem1.Trimesters;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrimesterRepository extends JpaRepository<Trimester, Long> {
   
}
