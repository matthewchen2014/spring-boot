package com.spring.service;

import com.spring.model.City;

public interface CityService {
    City getCity(Long id);

    City getCity(String name, String state);
}
