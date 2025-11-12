package com.example.studentmanagmentsystem1.Trimesters;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name= "trimester")
public class Trimester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name; 
    private String StartDate;
    private String EndDate;



       
    //Getters
    public String getName() {
        return Name;
    } 
    public String getStartDate() {
        return StartDate;
    }
    public String getEndDate() {
        return EndDate;
    }
    //Setters
    public void setName(String Name) {
        this.Name = Name;
    }   
    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }
    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }
}
