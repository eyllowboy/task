package com.example.tasl004.controllers;

import com.example.tasl004.entities.User;
import com.example.tasl004.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<?> addAmountOfContainers() {

        try {
            List<User> list = userService.getAllUsers();
            return ResponseEntity.ok(list);

        } catch (Exception e) {
            return new ResponseEntity<>("An error get users", HttpStatus.NOT_ACCEPTABLE);
        }

    }

}


