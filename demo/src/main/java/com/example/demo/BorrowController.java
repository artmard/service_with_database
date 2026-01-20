package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class BorrowController{
    private final BorrowRepository borrowRepository;
    public BorrowController(BorrowRepository borrowRepository)
    {
        this.borrowRepository = borrowRepository;
    }

//    @GetMapping("/")
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable("id") long id) {
//        Optional<Student> studentData = studentRepository.findById(id);
//        if (studentData.isPresent()) {
//            return studentData.get();
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/")
    public BorrowRecord createStudent(@RequestBody BorrowRecord borrowRecord) {
        return borrowRepository.save(new BorrowRecord(borrowRecord.getBookId(), borrowRecord.getStudentId(), borrowRecord.getDays()));
    }

    @PutMapping("/{id}")
    public BorrowRecord updateBorrowRecord(@PathVariable("id") long id, @RequestBody BorrowRecord borrowRecord) {
        Optional<BorrowRecord> borrowData = borrowRepository.findById(id);
        if (borrowData.isPresent()) {
            BorrowRecord updateRecord = borrowData.get();
            updateRecord.setReturned(true);
            return borrowRepository.save(updateRecord);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteStudent(@PathVariable("id") long id) {
//        studentRepository.deleteById(id);
//        return HttpStatus.NO_CONTENT;
//    }
//
//    @GetMapping("/grade")
//    public List<Student> getStudentById(@PathVariable("grade") int grade) {
//        return studentRepository.findByGrade(grade);
//    }
}