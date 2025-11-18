package com.example.studentmanagmentsystem1.StudentRegistration;

public class StudentRegiDto {
    private String intake;
    private String registrationDate;
    private String status;

    //getterrs
    public String getIntake() {
        return intake;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public String getStatus() {
        return status;
    }
    //setters
    public void setIntake(String intake) {
        this.intake = intake;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
