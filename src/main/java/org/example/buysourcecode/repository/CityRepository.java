package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findByCode(String code);

}
