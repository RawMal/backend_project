package com.example.backend_project.controllers;

import com.example.backend_project.models.Player;
import com.example.backend_project.models.Shop;
import com.example.backend_project.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping
    public ResponseEntity<List<Shop>> getAllWeapons(){
        List<Shop> shops = shopService.getAllWeapons();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }
}
