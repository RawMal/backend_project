package com.example.backend_project.services;


import com.example.backend_project.models.Monster;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MonsterService {

    @Autowired
    MonsterRepository monsterRepository;

    public Monster getRandomMonster(){
        Random random = new Random();
        long randomIndex = random.nextLong(1,4);
        return monsterRepository.findById(randomIndex).get();
    }
}
