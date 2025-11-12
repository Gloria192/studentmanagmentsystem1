package com.example.studentmanagmentsystem1.Trimesters;

public class TrimsterDto {
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
