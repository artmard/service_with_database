package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "klass")
    private String klass;
    @Column(name = "email")
    private String email;

    public Member(){
    }

    public Member(long id, String name, String klass, String email) {
        this.id = id;
        this.name = name;
        this.klass = klass;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKlass() {
        return klass;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", klass=" + klass + ", email=" + email +  "]";
    }
}