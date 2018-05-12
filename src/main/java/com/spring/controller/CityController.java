package com.spring.controller;

import com.spring.model.City;
import com.spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
//    @GetMapping("/{id}")
//    public City get(@PathVariable Long id) {
//        return cityService.getCity(id);
//    }

    @GetMapping("/find")
    public City get(String name, String state) {
        return cityService.getCity(name, state);
    }
}
