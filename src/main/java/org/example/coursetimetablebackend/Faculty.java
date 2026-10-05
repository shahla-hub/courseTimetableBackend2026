package org.example.coursetimetablebackend;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyId;

    private String facultyName;
    private String department;

    public Faculty() {
    }

    public Faculty(String facultyName, String department) {
        this.facultyName = facultyName;
        this.department = department;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
