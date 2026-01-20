package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BorrowRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByName(String title);
}