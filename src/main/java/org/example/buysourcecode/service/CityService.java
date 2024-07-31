package org.example.buysourcecode.service;

import org.example.buysourcecode.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> findCityAll();

}
