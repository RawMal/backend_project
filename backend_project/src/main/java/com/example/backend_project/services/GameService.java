package com.example.backend_project.services;

import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Game;
import com.example.backend_project.models.Player;
import com.example.backend_project.models.Reply;
import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.GameRepository;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    GameRepository gameRepository;


    public List<Game> getGames(){
       return gameRepository.findAll();
    }

    public Reply startNewGame(long playerId){
        Player player = playerService.getPlayerById(playerId).get();
        Game game = new Game(player);
        gameRepository.save(game);
        return new Reply("A new adventure has been started!");
    }

    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);}


    }






