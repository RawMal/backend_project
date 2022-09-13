package com.example.backend_project.services;

import com.example.backend_project.models.*;
import com.example.backend_project.repositories.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BattleService {

    @Autowired
    PlayerService playerService;

    @Autowired
    BattleRepository battleRepository;


    public Optional<Battle> getBattleById(Long id){return battleRepository.findById(id);}

    public int countVictoriousBattles() {
        return battleRepository.countByIsVictoriousTrue();
    }

    public boolean checkWinCondition(){
        return countVictoriousBattles() == 3;

    }
//    public Reply combatStart(Battle battle)
////            """ a reply object which says: you are in a forest and encounter a wolf
////"""
//            String.format("you are in a %s and encounter a %s",battle.getlocation(),battle.getmonster())
//    )

    public Reply Attack(Player player, Battle battle){
        String monsterType = battle.getMonster().getType();
        int damageDone = ThreadLocalRandom.current().nextInt(player.getWeapon().getMinDamage(),player.getWeapon().getMaxDamage());
        battle.getMonster().setHitPoints(battle.getMonster().getHitPoints()-damageDone);
        battleRepository.save(battle);
        return new Reply(String.format("You did %s damage to the %s." +
                "the %s has %sHP remaining",damageDone,monsterType,monsterType,battle.getMonster().getHitPoints()));
    }

    public Reply test(Player player, Battle battle){
        int minDamage = player.getWeapon().getMinDamage();
        int maxDamage = player.getWeapon().getMaxDamage();
        return new Reply(String.format("%s min and %s max",minDamage,maxDamage));
    }


    public Reply combatOutcome(Player player, Battle battle) {
        if (player.getLevel() > battle.getMonster().getLevel()) {
            battle.setVictorious(true);
            player.setNumberOfWins(player.getNumberOfWins()+1);
            battleRepository.save(battle);
            if (checkWinCondition()) {
                return new Reply ("You've defeated the monster and won the game! Congratulations, your Journey is Complete");
            } else {
                return new Reply("Your adventure continues");
            }

        } else {
            return new Reply ("Oh no, you've been defeated!");

        }

    }


}
