package com.example.studentmanagmentsystem1.Students;

import java.util.List;

import com.example.studentmanagmentsystem1.Courses.Course;
import com.example.studentmanagmentsystem1.StudentRegistration.StudentRegi;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;




@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
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

  

  @ManyToMany
@JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
    // Default constructor
    public Student() {}

    // Full constructor
    public Student(String firstName, String lastName, String email, String phone, 
                  String address, String gender, String dob, String motherName, 
                  String fatherName, String motherPhone, String fatherPhone, 
                  String guardianName, String guardianPhone, String guardianAddress) {
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

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherPhone() { return motherPhone; }
    public void setMotherPhone(String motherPhone) { this.motherPhone = motherPhone; }

    public String getFatherPhone() { return fatherPhone; }
    public void setFatherPhone(String fatherPhone) { this.fatherPhone = fatherPhone; }

    public String getGuardianName() { return guardianName; }
    public void setGuardianName(String guardianName) { this.guardianName = guardianName; }

    public String getGuardianPhone() { return guardianPhone; }
    public void setGuardianPhone(String guardianPhone) { this.guardianPhone = guardianPhone; }

    public String getGuardianAddress() { return guardianAddress; }
    public void setGuardianAddress(String guardianAddress) { this.guardianAddress = guardianAddress; }

    // public List<StudentRegi> getRegistrations() { return registrations; }
    // public void setRegistrations(List<StudentRegi> registrations) { this.registrations = registrations; }

    // Helper methods
    // public void addRegistration(StudentRegi registration) {
    //     registrations.add(registration);
    //     registration.setStudent(this);
    // }

    // public void removeRegistration(StudentRegi registration) {
    //     registrations.remove(registration);
    //     registration.setStudent(null);
    // }
    public List<Course> getCourses() {
        return courses;
        
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}   