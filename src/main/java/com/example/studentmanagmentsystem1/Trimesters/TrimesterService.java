package com.example.studentmanagmentsystem1.Trimesters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrimesterService {
    @Autowired
    private TrimesterRepository trimesterRepository;


    public List<Trimester> getAllTrimesters() {
        return trimesterRepository.findAll();
    }
    public Trimester getTrimesterById(Long id) {
        return trimesterRepository.findById(id).orElse(null);
    }   
    public Trimester createTrimester(Trimester trimester) {
        return trimesterRepository.save(trimester);
    }
    public Trimester updateTrimester(Long id, Trimester trimester) {
        return trimesterRepository.findById(id).map(existingTrimester -> {
            existingTrimester.setName(trimester.getName());
            existingTrimester.setStartDate(trimester.getStartDate());
            existingTrimester.setEndDate(trimester.getEndDate());
            return trimesterRepository.save(existingTrimester);
        }).orElse(null);
    }
    public void deleteTrimester(Long id) {
        trimesterRepository.deleteById(id);
    }



}
