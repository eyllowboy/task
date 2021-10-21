package com.example.tasl004.services;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import com.example.tasl004.repositories.HouseRepository;
import com.example.tasl004.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Transactional
    @Override
    public List<House> getAllHouseForUser(String name, int area, int amountOfRooms, int page, int size, String sorted, User user) {


        List<House> pageHouse = houseRepository.getAllHousesAreaAmountOfRooms(name, area, amountOfRooms, page, size, sorted, user);
        return pageHouse;


    }

    @Transactional
    public Page<House> getAllHouseforAdmin(int page, int size, String sorted) {
         return houseRepository.findAll( PageRequest.of(page, size, Sort.by(sorted)));

    }


    @Override
    @Transactional
    public Optional<House> getOneHouse(long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House addOneHouse(House house) {
        return houseRepository.save(house);
    }

    @Transactional
    @Override
    public House updateOneHouse(House house) {
        return houseRepository.save(house);
    }

    @Transactional
    @Override
    public void deleteOneHouse(long id) {
        houseRepository.deleteById(id);
    }
}
