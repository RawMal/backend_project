package com.example.backend_project.DataLoader;


import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Game;
import com.example.backend_project.models.Monster;
import com.example.backend_project.models.Player;
import com.example.backend_project.models.Weapon;
import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.GameRepository;
import com.example.backend_project.repositories.MonsterRepository;
import com.example.backend_project.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BattleRepository battleRepository;

    @Autowired
    MonsterRepository monsterRepository;
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Player player1 = new Player("Bob",5 );
        Player player2 = new Player("john",0);
        playerRepository.saveAll(Arrays.asList(player1,player2));


        Game game1 = new Game(player1);

        gameRepository.saveAll(Arrays.asList(game1));






//        monsterRepository.saveAll(Arrays.asList(monster1, monster2,monster3));

        Battle battle1 = new Battle("Forest", game1  , new Monster("Dracula",4,10,5));
        Battle battle2 = new Battle("Cave", game1,new Monster("Wolf", 2,15,5));
        Battle battle3 = new Battle("Mountain", game1,new Monster("Demon", 3,45,20));

//        battle1.setGame(game1);
//        battle2.setGame(game1);
//        battle3.setGame(game1);


        battleRepository.saveAll(Arrays.asList(battle1, battle2, battle3));


        Weapon weapon1 = new Weapon("sword",1,35,25,0.4f,player1);






    }

//    post request /games = a message saying : welcome to the game...

//    after defeating a monster, the player gets a random amount of gold

//    context message when encountering a new monster

//    they can buy weapons (with a certain weapon level) using the gold they have

//    patch request - is used to change the weapon level of the player.

//    Another extension: adding health/different attacks




}
