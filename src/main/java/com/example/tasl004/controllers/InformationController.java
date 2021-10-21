package com.example.tasl004.controllers;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import com.example.tasl004.services.HouseService;
import com.example.tasl004.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/information")
public class InformationController {
    @Autowired
    UserService userService;

    @Autowired
    HouseService houseService;

    @GetMapping("/allUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addAmountOfContainers() {

        try {
            List<User> list = userService.getAllUsers();
            return ResponseEntity.ok(list);

        } catch (Exception e) {
            return new ResponseEntity<>("An error get users", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping("/getAllHouses")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllHousesForAllUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            @RequestParam(value = "sorted", required = false, defaultValue = "name") String sorted) {

        try {
            Page<House> pageHouse = houseService.getAllHouseforAdmin(  page,   size,  sorted);
            return ResponseEntity.ok(pageHouse);
        } catch (Exception e) {
            return new ResponseEntity<>("An error show  houses", HttpStatus.NOT_ACCEPTABLE);
        }
    }



}


