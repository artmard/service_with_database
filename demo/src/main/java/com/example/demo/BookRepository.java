package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByAvailable(boolean available);
}