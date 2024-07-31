package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.District;
import org.example.buysourcecode.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

    List<Town> findAllByDistrict(District district);

}
