package com.example.tasl004.services;

import com.example.tasl004.entities.House;
import com.example.tasl004.repositories.HouseRepository;
import com.example.tasl004.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Transactional
    public Page<House> getAllHouse(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Page<House> getAllHouse(int area, int amountOfRooms, Pageable pageable) {
        return houseRepository.findAllbyAreaAmountOfRooms(area,amountOfRooms,pageable);
    }



    @Override
    @Transactional
    public Page<House> getHouseByAmountOfRooms(int amountOfRooms, Pageable pageable) {
        return houseRepository.findAllbyAmountOfRooms(amountOfRooms,pageable);
    }

    @Override
    @Transactional
    public Page<House> getHouseByArea(int area, Pageable pageable) {
        return houseRepository.findAllbyAmountOfArea(area,pageable);
    }

    @Override
    @Transactional
    public Optional<House> getOneHouse(long id) {
        return houseRepository.findById(id);
    }

    @Override
    public  House addOneHouse(House house) {
        return houseRepository.save(house);
    }

    @Transactional
    @Override
    public  House  updateOneHouse(House house) {
        return houseRepository.save(house);
    }

    @Transactional
    @Override
    public void deleteOneHouse(long id) {
         houseRepository.deleteById(id);
    }
}
