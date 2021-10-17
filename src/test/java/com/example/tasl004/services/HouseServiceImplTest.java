package com.example.tasl004.services;//package com.example.tasl004.services;
//
//import com.example.tasl004.entities.House;
//import com.example.tasl004.repositories.HouseRepository;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//public class HouseServiceImplTest {
//
//    @Mock
//    private HouseRepository houseRepository;
//    @Mock
//    private HouseServiceImpl   houseService ;
//
//    public HouseServiceImplTest(HouseRepository houseRepository, HouseServiceImpl houseService) {
//        MockitoAnnotations.initMocks(this);
//        this.houseRepository = houseRepository;
//        MockitoAnnotations.initMocks(this);
//        this.houseService = houseService;
//    }
//
//    @Test
//    public void getHouseByArea() {
//        given(houseRepository.findAllbyAmountOfArea(50, PageRequest.of(1, 5, Sort.by("name"))))
//                .willReturn((Page<House>) new House("house1",50,2,false));
//
//        Page<House> house = houseService.getHouseByArea(50,PageRequest.of(1, 5, Sort.by("name")));
//        assertThat(house).isNotEmpty();
//
//    }
//}