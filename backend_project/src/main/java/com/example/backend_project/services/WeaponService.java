package com.example.backend_project.services;

import com.example.backend_project.models.Shop;
import com.example.backend_project.models.Weapon;
import com.example.backend_project.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeaponService {

    @Autowired
    WeaponRepository weaponRepository;

    public Optional<Weapon> getWeaponById(Long id){
        return weaponRepository.findById(id);
    }
}
