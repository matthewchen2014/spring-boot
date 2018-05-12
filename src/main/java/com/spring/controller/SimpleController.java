package com.spring.controller;

import com.spring.common.Student;
import com.spring.config.Config;
import com.spring.config.RandomConfig;
import com.spring.model.CollegeStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleController {
    @Autowired
    private  Student student;
    @Autowired
    private Config config;
    @Value("${address}")
    private String server;
    @Value("{name}")
    private String name;
    @Autowired
    private RandomConfig randomConfig;
    @Value("${app.description}")
    private String appDesc;
    @GetMapping("/{id}")
    public String sayHello(@PathVariable Long id) {
        System.out.println(config.getServers());
        System.out.println(server);
        System.out.println(name);
        System.out.println(randomConfig.getSecret());
        System.out.println(appDesc);
        CollegeStudent student1 = new CollegeStudent(2018);
        CollegeStudent student2 = new CollegeStudent(2018);
        System.out.println(student1.equals(student2));
        System.out.println(config.getFirstName());
        System.out.println(id);
        return "Hello, World";
    }
}
