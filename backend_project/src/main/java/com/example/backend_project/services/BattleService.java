package com.example.backend_project.services;

import com.example.backend_project.models.Battle;
import com.example.backend_project.repositories.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    @Autowired
    PlayerService playerService;

    @Autowired
    BattleRepository battleRepository;


    //public Battle combatOutcome()



}
