package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface bookRepository extends JpaRepository<book,
        Long> {
    List<book> findByPublished(boolean published);

    List<book> findByTitleContaining(String title);
}