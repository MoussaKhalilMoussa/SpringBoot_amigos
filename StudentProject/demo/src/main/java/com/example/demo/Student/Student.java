package com.example.demo.Student;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="student_sequence"
    )
    private Long id;
    private String name ;
    private String surname;
    private  String email ;
//    private LocalDate dob;
//    private Integer age ;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   String surname
                   )
    {
        this.id = id;
        this.name = name;
        this.surname=surname;
        this.email = email;

    }

    public Student(String name,
                   String email,
                   String surname)
    {
        this.name = name;
        this.email = email;
        this.surname =surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
