package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.District;
import org.example.buysourcecode.model.Town;
import org.example.buysourcecode.repository.TownRepository;
import org.example.buysourcecode.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository townRepository;

    @Override
    public List<Town> findTownAll(District district) {
        return townRepository.findAllByDistrict(district);
    }
}
