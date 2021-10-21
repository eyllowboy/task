package com.example.tasl004.services;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

public interface HouseService {

    List<House> getAllHouseForUser(String name, int area, int amountOfRooms, int page, int size, String sorted, User user);

    Page<House> getAllHouseforAdmin(int page, int size, String sorted );

//    Page<House> getAllHouse(Pageable pageable);
//
//    Page<House> getAllHouse(int area, int amountOfRooms, Pageable pageable);
//
//    Page<House> getHouseByAmountOfRooms(int amountOfRooms, Pageable pageable);
//
//    Page<House> getHouseByArea(int area, Pageable pageable);
//
    Optional<House> getOneHouse(long id);

    House addOneHouse(House house);

    House updateOneHouse(House house);

    void deleteOneHouse( long id);



}
