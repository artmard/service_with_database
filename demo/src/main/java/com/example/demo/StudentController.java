package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController{
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            return studentData.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(student.getFullName(),student.getGrade(),student.getEmail(), true));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            Student updateStudent = studentData.get();
            updateStudent.setFullName(student.getFullName());
            updateStudent.setGrade(student.getGrade());
            updateStudent.setEmail(student.getEmail());
            updateStudent.setActive(student.isActive());
            return studentRepository.save(updateStudent);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStudent(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping("/grade")
    public List<Student> getStudentById(@PathVariable("grade") int grade) {
        return studentRepository.findByGrade(grade);
    }
}