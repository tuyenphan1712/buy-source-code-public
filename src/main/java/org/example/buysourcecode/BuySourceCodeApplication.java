package org.example.buysourcecode;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.buysourcecode.model.City;
import org.example.buysourcecode.model.District;
import org.example.buysourcecode.model.Town;
import org.example.buysourcecode.repository.CityRepository;
import org.example.buysourcecode.repository.DistrictRepository;
import org.example.buysourcecode.repository.TownRepository;
import org.example.buysourcecode.util.jsoncocnverter.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class BuySourceCodeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BuySourceCodeApplication.class, args);
    }

    @Autowired
    private ResourceLoader resourceLoader;

        @Autowired
        CityRepository cityRepository;

        @Autowired
        DistrictRepository districtRepository;

        @Autowired
        TownRepository townRepository;

        @Autowired
        JsonConverter jsonConverter;

        public BuySourceCodeApplication(CityRepository cityRepository, DistrictRepository districtRepository, TownRepository townRepository){
            this.cityRepository = cityRepository;
            this.districtRepository = districtRepository;
            this.townRepository = townRepository;
        }

        //import json data
        @Override
        public void run(String... args) throws Exception {

//            //import City data
//            try {
//            Resource resourceCity = resourceLoader.getResource("classpath:data/tinh_tp.json");
//            String cityJson = new String(FileCopyUtils.copyToByteArray(resourceCity.getInputStream()));
//
//            List<City> cities = new ArrayList<>();
//            Map<String, Map<String, String>> dataDistricts = jsonConverter.fromJson(cityJson, Map.class);
//
//            dataDistricts.values().forEach(district -> {
//                City newCity = City.builder()
//                        .slug(district.get("slug"))
//                        .name(district.get("name"))
//                        .nameWithType(district.get("name_with_type"))
//                        .code(district.get("code"))
//                        .build();
//                cities.add(newCity);
//            });
//
//            cityRepository.saveAll(cities);
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//---------------------------------------------------------------------------------------------------------------
        // import District data
//
//        try {
//            Resource resourceDistrict = resourceLoader.getResource("classpath:data/quan_huyen.json");
//            String districtJson = new String(FileCopyUtils.copyToByteArray(resourceDistrict.getInputStream()));
//
//            List<District> districts = new ArrayList<>();
//            Map<String, Map<String, String>> dataDistricts = jsonConverter.fromJson(districtJson, Map.class);
//
//            dataDistricts.values().forEach(district -> {
//                District newDistrict = District.builder()
//                        .slug(district.get("slug"))
//                        .name(district.get("name"))
//                        .nameWithType(district.get("name_with_type"))
//                        .code(district.get("code"))
//                        .city(cityRepository.findByCode(district.get("parent_code")))
//                        .build();
//                districts.add(newDistrict);
//            });
//
//            districtRepository.saveAll(districts);
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//---------------------------------------------------------------------------------------------------------------

////        //import Town data
////
//            try {
//                Resource resourceTown = resourceLoader.getResource("classpath:data/xa_phuong.json");
//                String townJson = new String(FileCopyUtils.copyToByteArray(resourceTown.getInputStream()));
//
//                List<Town> towns = new ArrayList<>();
//                Map<String, Map<String, String>> dataTowns = jsonConverter.fromJson(townJson, Map.class);
//
//                dataTowns.values().forEach(town -> {
//                    Town newTown = Town.builder()
//                            .slug(town.get("slug"))
//                            .name(town.get("name"))
//                            .nameWithType(town.get("name_with_type"))
//                            .code(town.get("code"))
//                            .district(districtRepository.findByCode(town.get("parent_code")))
//                            .build();
//                    towns.add(newTown);
//                });
//
//                townRepository.saveAll(towns);
//
//            } catch (IOException e){
//                e.printStackTrace();
//            }


        }


}
