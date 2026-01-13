package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Club> findByName(String title);
    List<Club> findByTitleContaining(String title);
}
