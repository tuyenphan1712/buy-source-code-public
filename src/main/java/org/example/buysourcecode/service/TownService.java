package org.example.buysourcecode.service;

import org.example.buysourcecode.model.District;
import org.example.buysourcecode.model.Town;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TownService {

    List<Town> findTownAll(District district);

}
