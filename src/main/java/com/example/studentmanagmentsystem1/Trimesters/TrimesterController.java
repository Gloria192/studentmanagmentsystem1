package com.example.studentmanagmentsystem1.Trimesters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/trimesters")
public class TrimesterController {

    @Autowired
    private TrimesterService trimesterService;  

    @GetMapping("/{id}")
    public Trimester getTrimesterById(@RequestParam Long id) {
        return trimesterService.getTrimesterById(id);
    }
    @GetMapping
    public java.util.List<Trimester> getAllTrimesters() {
        return trimesterService.getAllTrimesters();
    }
    @PostMapping("/create")
    public Trimester createTrimester(@RequestBody  Trimester trimester) {
    
        return trimesterService.createTrimester(trimester); 
    }
    @PutMapping("/{id}")
    public Trimester updateTrimester(@PathVariable Long id , @RequestBody Trimester trimester) {
    
        return trimesterService.updateTrimester( id,trimester);
    }
    @DeleteMapping("/{id}")
    public String deleteTrimester(@PathVariable Long id) {
        trimesterService.deleteTrimester(id);
        return "Trimester deleted successfully with id: " + id;
    }
    
}
