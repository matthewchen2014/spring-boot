package com.spring.service.impl;

import com.spring.dao.CityRepository;
import com.spring.model.City;
import com.spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCity(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public City getCity(String name, String state) {
        return cityRepository.findByNameAndState(name, state);
    }
}
