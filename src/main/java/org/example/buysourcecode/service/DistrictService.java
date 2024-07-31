package org.example.buysourcecode.service;

import org.example.buysourcecode.model.City;
import org.example.buysourcecode.model.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    List<District> findDistrictsAll(City city);
}
