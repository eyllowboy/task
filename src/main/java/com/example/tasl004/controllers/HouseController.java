package com.example.tasl004.controllers;


import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import com.example.tasl004.services.HouseService;
import com.example.tasl004.services.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @Autowired
    UserService userService;



    @GetMapping("/getfilterHouses")
    public ResponseEntity<?> getAllHouses(
            @RequestParam(value = "area", required = false, defaultValue = "0") @PositiveOrZero int area,
            @RequestParam(value = "amountOfRooms", required = false, defaultValue = "0") @PositiveOrZero int amountOfRooms,
            @RequestParam(value = "nameHouse", required = false, defaultValue = "null") String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            @RequestParam(value = "sorted", required = false, defaultValue = "name") String sorted,
            HttpServletRequest request) {

        try {
            String userName = request.getRemoteUser();
            User user = userService.findByUsername(userName);
            List<House> pageHouse = houseService.getAllHouseForUser(name, area, amountOfRooms, page, size, sorted, user);
            return ResponseEntity.ok(pageHouse);
        } catch (Exception e) {
            return new ResponseEntity<>("An error show houses", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getOneHouse/{id}")
    public ResponseEntity<?> showOneHouse(@PathVariable long id) {

        try {
            Optional<House> optional = houseService.getOneHouse(id);
            House house = optional.orElseThrow(() -> new ServiceException("Error get one house"));
            return ResponseEntity.ok(house);
        } catch (Exception e) {
            return new ResponseEntity<>("An error show one house", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/addOneHouse")
    public ResponseEntity<?> addOneHouse(@Valid House house, HttpServletRequest request, Errors errors) {

        try {

            if (errors.hasErrors()) {
                return ResponseEntity.ok(errors.toString());
            }
            String userName = request.getRemoteUser();
            User user = userService.findByUsername(userName);
            house.setUser(user);
            House house1 = houseService.addOneHouse(house);

            return ResponseEntity.ok(house1);

        } catch (Exception e) {
            return new ResponseEntity<>("An error add one house", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/updateOneHouse")
    public ResponseEntity<?> updateOneHouse(@Valid House house, Errors errors) {

        try {
            if (errors.hasErrors()) {
                System.out.println(errors.getAllErrors());
                return ResponseEntity.ok(errors.getAllErrors());
            }
            House house1 = houseService.updateOneHouse(house);

            return ResponseEntity.ok(house1);

        } catch (Exception e) {
            return new ResponseEntity<>("An error update one house", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteOneHouse/{id}")
    public ResponseEntity<?> deleteOneHouse(@PathVariable long id) {

        try {
            houseService.deleteOneHouse(id);
            return ResponseEntity.ok("house deleted");

        } catch (Exception e) {
            return new ResponseEntity<>("An error delete one house", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

