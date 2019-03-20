package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class School {
    Student student;

    public void setStudent(Student student) {
        System.out.println("School set student:"+student.toString());
        this.student = student;
    }
}
