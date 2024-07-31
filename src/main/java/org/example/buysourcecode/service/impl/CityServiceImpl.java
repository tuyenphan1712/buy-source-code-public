package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.City;
import org.example.buysourcecode.repository.CityRepository;
import org.example.buysourcecode.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findCityAll() {
        return cityRepository.findAll();
    }
}
