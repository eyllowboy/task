package com.example.tasl004.repositories;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseRepositoryCustom {


    List<House> getAllHousesAreaAmountOfRooms(String name, int area, int amountOfRooms, int page, int size, String sorted, User user);




}
