package com.example.backend_project.services;

import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Reply;
import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    BattleService battleService;

    @Autowired
    PlayerService playerService;

    @Autowired
    MonsterRepository monsterRepository;

    @Autowired
    BattleRepository battleRepository;


//    public List<Game> getGames(){
//        return gameRepository.findAll();}


    }






