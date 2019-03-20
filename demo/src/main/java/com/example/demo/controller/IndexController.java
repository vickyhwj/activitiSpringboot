package com.example.demo.controller;

import com.example.demo.config.StudentProperies;
import com.example.demo.service.MyService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Controller
public class IndexController {
    @Autowired
    DataSource dataSource;


    @Autowired
    StudentProperies studentProperies;



    @PersistenceContext
    EntityManager entityManager;



    @RequestMapping("/hello")
    public  void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("dada");

    }
}
