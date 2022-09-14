package com.example.backend_project.services;

import com.example.backend_project.models.Shop;
import com.example.backend_project.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public List<Shop> getAllWeapons(){
        return shopRepository.findAll();
    }




}
