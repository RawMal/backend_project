package com.example.backend_project.services;

import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Game;
import com.example.backend_project.repositories.GameRepository;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /*public void checkWinCondition(){
        List<Battle> battles = new ArrayList<>();
        for (Battle completedBattles: battles){
            if (completedBattles.isVictorious() == true && battles.size() == 3);
        } return String"Congratulations, your Journey is Complete";*/
    

    }
}


