package com.spring.controller;

import com.spring.model.CollegeStudent;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/index", produces = "text/plain", method = RequestMethod.POST)
    public String index() {
        return "Hello";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public CollegeStudent get(@RequestBody CollegeStudent collegeStudent){
        System.out.println(collegeStudent.getBirthDay());
        return collegeStudent;
    }
}
