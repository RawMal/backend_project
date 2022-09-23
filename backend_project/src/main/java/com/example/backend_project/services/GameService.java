package com.example.backend_project.services;

import com.example.backend_project.models.*;
import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.GameRepository;
import com.example.backend_project.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    PlayerService playerService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    BattleRepository battleRepository;

    @Autowired
    MonsterRepository monsterRepository;





    public List<Game> getGames(){
       return gameRepository.findAll();
    }

    public Reply startNewGame(long playerId){
        Player player = playerService.getPlayerById(playerId).get();
        Game game = new Game(player);
//        populating game
        Monster monster1 = new Monster("Goblin", 10, 5);
        Monster monster2 = new Monster("Wolf", 15, 5);
        Monster monster3 = new Monster("Troll", 40, 20);

        Battle battle1 = new Battle("Forest", game, monster1);
        Battle battle2 = new Battle("Cave", game, monster2);
        Battle battle3 = new Battle("Mountains", game, monster3);

        game.addBattle(battle1);
        game.addBattle(battle2);
        game.addBattle(battle3);
        monsterRepository.saveAll(Arrays.asList(monster1, monster2,monster3));
        battleRepository.saveAll(Arrays.asList(battle1, battle2, battle3));

        gameRepository.save(game);
        return new Reply(String.format("Welcome %s! A new adventure has started!",game.getPlayer().getName()));
    }


    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);}


    }






