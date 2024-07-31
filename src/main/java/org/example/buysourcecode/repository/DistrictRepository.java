package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.City;
import org.example.buysourcecode.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {


    District findByCode(String code);
    List<District> findAllByCity(City city);

}
