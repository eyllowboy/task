package com.example.tasl004.services;

import com.example.tasl004.entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

public interface HouseService {

    Page<House> getAllHouse(Pageable pageable);

    Page<House> getAllHouse(int area, int amountOfRooms, Pageable pageable);

    Page<House> getHouseByAmountOfRooms(int amountOfRooms, Pageable pageable);

    Page<House> getHouseByArea(int area, Pageable pageable);

    Optional<House> getOneHouse(long id);

    House addOneHouse(House house);

    House updateOneHouse(House house);

    void deleteOneHouse( long id);

}
