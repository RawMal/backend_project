package com.example.backend_project.services;

import com.example.backend_project.models.Game;
import com.example.backend_project.repositories.GameRepository;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    PlayerService playerService;

    @Autowired
    MonsterRepository monsterRepository;

    @Autowired
    GameRepository gameRepository;

    public List<Game> getGames(){
        return gameRepository.findAll();}
}
