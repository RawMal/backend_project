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

        /*
        Issues to fix:
        When you create a new game with a new player, their list of battles is empty. also their win condition will also be wrong.


         */


//
//        Player player1 = new Player("Frodo");
//
//        Game game1 = new Game(player1);
//
//        Monster monster1 = new Monster("Goblin", 10, 5);
//        Monster monster2 = new Monster("Wolf", 15, 5);
//        Monster monster3 = new Monster("Troll", 40, 20);
//
//        Battle battle1 = new Battle("Forest", game1, monster1);
//        Battle battle2 = new Battle("Cave", game1, monster2);
//        Battle battle3 = new Battle("Mountains", game1, monster3);

        Shop shop1 = new Shop("Ye Olde Shop");

        Weapon weapon1 = new Weapon(
                "Dagger", 14, 10, 5, 2, shop1);
        Weapon weapon2 = new Weapon(
                "Great axe", 50, 40, 5,  7, shop1);
        Weapon weapon3 = new Weapon(
                "Spear", 35, 8, 5,  5, shop1);
        Weapon weapon4 = new Weapon(
                "Sword", 25, 15, 5,  4, shop1);


//        playerRepository.saveAll(Arrays.asList(player1));
//        monsterRepository.saveAll(Arrays.asList(monster1, monster2,monster3));
//        battleRepository.saveAll(Arrays.asList(battle1, battle2, battle3));
//
//        gameRepository.saveAll(Arrays.asList(game1));
        shopRepository.saveAll(Arrays.asList(shop1));
        weaponRepository.saveAll(Arrays.asList(weapon1, weapon2, weapon3, weapon4));


    }

}
