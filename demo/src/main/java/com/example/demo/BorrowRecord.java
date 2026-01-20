package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
public class BorrowRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "bookId")
    private long bookId;
    @Column(name = "studentId")
    private long studentId;
    @Column(name = "borrowDate")
    private LocalDate borrowDate;
    @Column(name = "days")
    private int days;
    @Column(name = "returned")
    private boolean returned;

    public BorrowRecord(long bookId, long studentId, int days) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.borrowDate = LocalDate.now();
        this.days = days;
        this.returned = false;
    }


    @Override
    public String toString() {
        return "BorrowRecord{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", studentId=" + studentId +
                ", borrowDate=" + borrowDate +
                ", days=" + days +
                ", returned=" + returned +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDays(int days) {
        this.days = days;
    }



    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public long getId() {
        return id;
    }

    public long getBookId() {
        return bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public int getDays() {
        return days;
    }

    public boolean isReturned() {
        return returned;
    }
}