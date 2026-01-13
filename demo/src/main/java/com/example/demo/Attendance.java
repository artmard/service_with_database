package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;
    @Column(name = "memberId")
    private String memberId;
    @Column(name = "status")
    private String status;

    public Attendance() {
    }

    public Attendance(long eventId, String memberId, String status) {
        this.eventId = eventId;
        this.memberId = memberId;
        this.status = status;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getEventId() {
        return eventId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "eventId=" + eventId +
                ", memberId='" + memberId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}