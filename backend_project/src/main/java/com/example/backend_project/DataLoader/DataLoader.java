package com.example.backend_project.DataLoader;


import com.example.backend_project.models.*;
import com.example.backend_project.repositories.*;
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

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    WeaponRepository weaponRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Player player1 = new Player("Bob",5,5 );
        Player player2 = new Player("john",0,0);

        Game game1 = new Game(player1);

        Monster monster1 = new Monster("Dracula",4, 10, 5);
        Monster monster2 = new Monster("Wolf", 2, 15, 5);
        Monster monster3 = new Monster("Demon", 3, 45, 20);

        Battle battle1 = new Battle("Forest", game1, monster1);
        Battle battle2 = new Battle("Cave", game1, monster2);
        Battle battle3 = new Battle("Mountain", game1, monster3);

//        Weapon weapon1 = new Weapon("sword",1,12,17,0.4f,player1);

//        battle1.setVictorious(true);
//        battle2.setVictorious(true);
//        battle3.setVictorious(true);

        Shop shop1 = new Shop("Ye Old Shop");

        Weapon weapon1 = new Weapon("Sword", 2, 25, 15, 5, player1, 5, shop1);
        Weapon weapon2 = new Weapon("Great axe", 2, 50, 40, 5, player1, 5, shop1);

        playerRepository.saveAll(Arrays.asList(player1,player2));
        monsterRepository.saveAll(Arrays.asList(monster1, monster2,monster3));
        battleRepository.saveAll(Arrays.asList(battle1, battle2, battle3));

        gameRepository.saveAll(Arrays.asList(game1));
        shopRepository.saveAll(Arrays.asList(shop1));
        weaponRepository.saveAll(Arrays.asList(weapon1, weapon2));






//        monsterRepository.saveAll(Arrays.asList(monster1, monster2,monster3));

//        Battle battle1 = new Battle("Forest", game1  , new Monster("Dracula",4,10,5));
//        Battle battle2 = new Battle("Cave", game1,new Monster("Wolf", 2,15,5));
//        Battle battle3 = new Battle("Mountain", game1,new Monster("Demon", 3,45,20));

//        battle1.setGame(game1);
//        battle2.setGame(game1);
//        battle3.setGame(game1);


        battleRepository.saveAll(Arrays.asList(battle1, battle2, battle3));


//        Weapon weapon1 = new Weapon("sword",1,35,25,0.4f,player1);






    }

//    post request /games = a message saying : welcome to the game...

//    after defeating a monster, the player gets a random amount of gold

//    context message when encountering a new monster

//    they can buy weapons (with a certain weapon level) using the gold they have

//    patch request - is used to change the weapon level of the player.

//    Another extension: adding health/different attacks




}
