package com.example.demo.controller;

import com.example.demo.config.StudentProperies;

import com.example.demo.pojo.Customer;
import com.example.demo.pojo.CustomerRepository;
import org.activiti.engine.*;
import org.omg.CORBA.CustomMarshal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/act")
public class ActivitController {
    @Autowired
    DataSource dataSource;



    @Autowired
    StudentProperies studentProperies;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    ProcessEngine processEngine;

    @Autowired
    RepositoryService repositoryService;

    @RequestMapping("/deploy")
    @ResponseBody
    public  String deploy(){
        repositoryService.createDeployment().addClasspathResource("processes/pay.bpmn").deploy();

        return "deploy";
    }

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    IdentityService identityService;

    @RequestMapping("/start")
    @ResponseBody
    public  String start(){
        identityService.setAuthenticatedUserId("vicky");
        runtimeService.startProcessInstanceByKey("myProcess_1");
        return  "success";
    }

    @Autowired
    CustomerRepository customerRepository;
    @RequestMapping("/save")
    @ResponseBody
    public String saveCustom(){
        List<Customer> customers= customerRepository.findByLastName("i");
        return  "save";
    }
}
