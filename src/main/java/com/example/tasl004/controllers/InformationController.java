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



}


