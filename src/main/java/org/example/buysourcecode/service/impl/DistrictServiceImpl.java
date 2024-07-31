package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.City;
import org.example.buysourcecode.model.District;
import org.example.buysourcecode.repository.DistrictRepository;
import org.example.buysourcecode.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> findDistrictsAll(City city) {
        return districtRepository.findAllByCity(city);
    }
}
