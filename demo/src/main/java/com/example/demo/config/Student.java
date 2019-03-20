package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Student {
    public Student(){
        System.out.println("construct");
    }
    public void init(){

        System.out.println("init"+this.toString());
    }
}
