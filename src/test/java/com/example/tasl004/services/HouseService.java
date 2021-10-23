package com.example.tasl004.services;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import com.example.tasl004.repositories.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class HouseServiceTest{

    private HouseRepository repository;

    private HouseService  service;

    @BeforeEach
    void setUp() {
        repository = mock(HouseRepository.class) ;
        service = new HouseServiceImpl(repository);
    }

    @Test
    public void findOneHouseTest(){

        given(repository.findById(2l))
                .willReturn(Optional.of(new House(2l, "house2", 70, 3, false)));

          Optional<House> oneHouse = service.getOneHouse(2);
         assertThat(oneHouse.get()).isEqualTo(new House(2l, "house2", 70, 3, false));
    }

    @Test
    public void addOneHouse(){
        given(repository.save(new House(2l, "house2", 70, 3, false)))
                .willReturn(new House(2l, "house2", 70, 3, false));

        assertThat(service.addOneHouse(new House(2l, "house2", 70, 3, false)))
                .isEqualTo(new House(2l, "house2", 70, 3, false));
    }

    @Test
    public void filtering(){
        User user = new User(2l,"user","$2a$12$Z6ONOLjiUZIkCBCaxwawKu0b6rCITC6.Kr0LuKDYFHgf0zywltbHG");

        given(repository.getAllHousesAreaAmountOfRooms("house3",0,0,0,5,"name",user))
                .willReturn(Stream.of(new House(3l,"house3",55,2,false,user)).collect(Collectors.toList()));

        assertThat(service.getAllHouseForUser("house3",0,0,0,5,"name",user))
                .isEqualTo(List.of(new House(3l,"house3",55,2,false,user)));
    }

    @Test
    public void deleted(){
        service.deleteOneHouse(2l);
        verify(repository,times(1)).deleteById(2l);

    }
}