package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "students")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fullName")
    private String fullName;
    @Column(name = "grade")
    private int grade;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean active;

    public Student() {
    }

    public Student(String fullName, int grade, String email, boolean active) {
        this.fullName = fullName;
        this.grade = grade;
        this.email = email;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", grade=" + grade +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }
}