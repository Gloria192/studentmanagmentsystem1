package com.example.studentmanagmentsystem1.Students;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String dob;
    private String motherName;
    private String fatherName;
    private String motherPhone;
    private String fatherPhone;
    private String guardianName;
    private String guardianPhone;
    private String guardianAddress;
    // constructor
    public Student() {
    }

    // constructor
    public Student( String firstName, String lastName, String email, String phone, String address,
                   String gender, String dob, String motherName, String fatherName, String motherPhone,
                   String fatherPhone, String guardianName, String guardianPhone, String guardianAddress) {
       
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.motherPhone = motherPhone;
        this.fatherPhone = fatherPhone;
        this.guardianName = guardianName;
        this.guardianPhone = guardianPhone;
        this.guardianAddress = guardianAddress;
    }

    // Getters and Setters

   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }



    // @ManyToMany(mappedBy = "students")
    // private Set<Course> course= new HashSet<>();
    // public Set<Course> getCourses() {
    //     return course;
    // }   

    // @Override
    // public String toString() {
    //     return "Student{" +
    //             "id=" + id +
    //             ", firstName='" + firstName + '\'' +
    //             ", lastName='" + lastName + '\'' +
    //             ", email='" + email + '\'' +
    //             ", phone='" + phone + '\'' +
    //             ", address='" + address + '\'' +
    //             ", gender='" + gender + '\'' +
    //             ", dob='" + dob + '\'' +
    //             ", motherName='" + motherName + '\'' +
    //             ", fatherName='" + fatherName + '\'' +
    //             ", motherPhone='" + motherPhone + '\'' +
    //             ", fatherPhone='" + fatherPhone + '\'' +
    //             ", guardianName='" + guardianName + '\'' +
    //             ", guardianPhone='" + guardianPhone + '\'' +
    //             ", guardianAddress='" + guardianAddress + '\'' +
    //             '}';
    // }
}
