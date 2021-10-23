package com.example.tasl004.repositories;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class HouseRepositoryTest {

    @Autowired
    private HouseRepository repository;

    @Test
    void getOneHouse() {
        final Optional<House> byId = repository.findById(2l);
        House house =byId.get();

        assertThat(house.getId()).isEqualTo(2);
        assertThat(house.getAmountOfRooms()).isEqualTo(3);
        assertThat(house.getArea()).isEqualTo(70);
        assertThat(house.getName()).isEqualTo("house2");


    }
    @Test
    void Filtering() {
        User user = new User(2l,"user","$2a$12$Z6ONOLjiUZIkCBCaxwawKu0b6rCITC6.Kr0LuKDYFHgf0zywltbHG");
        final List<House> houses = repository.getAllHousesAreaAmountOfRooms(null, 55, 0, 0, 5, "area", user);
        assertThat(houses.get(0).getName()).isEqualTo("house3");
    }
}