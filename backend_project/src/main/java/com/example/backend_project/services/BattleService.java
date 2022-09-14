package com.example.backend_project.services;

import com.example.backend_project.models.*;
import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.PlayerRepository;
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

    @Autowired
    PlayerRepository playerRepository;


    public Optional<Battle> getBattleById(Long id){return battleRepository.findById(id);}

    public int countVictoriousBattles() {
        return battleRepository.countByIsVictoriousTrue();
    }

    public boolean checkWinCondition(){
        return countVictoriousBattles() == 3;

    }

    public Reply processFight(Player player, Battle battle){
        combatOutcome(player,battle);

        playerAttack(player,battle);
        combatOutcome(player,battle);
        monsterAttack(player,battle);
        combatOutcome(player,battle);
        return new Reply();
    }

//    if player defeats monster & player wins game - return reply
//    if player defeats monstser & not wins game - return reply
//    if player lost to monster - return reply
//    if player and monster both alive - continue logic
//    player attacks
//    repeat checks - return attack message followed by victory/adventure continues
//    monster attacks
//    repeat checks - return attack message followed by loss message
//    return reply of both attacks





    public Reply playerAttack(Player player, Battle battle){


            String monsterType = battle.getMonster().getType();
            int damageDone = ThreadLocalRandom.current().nextInt(player.getWeapon().getMinDamage(),player.getWeapon().getMaxDamage());
            battle.getMonster().setHitPoints(battle.getMonster().getHitPoints()-damageDone);
            battleRepository.save(battle);

            return new Reply(String.format("You did %s damage to the %s." +
                    "the %s has %sHP remaining",damageDone,monsterType,monsterType,battle.getMonster().getHitPoints()));

        }



    public Reply monsterAttack(Player player, Battle battle){

        int damageDone = ThreadLocalRandom.current().nextInt(battle.getMonster().getMinDamage(),battle.getMonster().getMaxDamage());
        player.setHitPoints(player.getHitPoints()-damageDone);
        playerRepository.save(player);
        return new Reply(String.format("The monster attacked you for %s damage." +
                "You have %sHP remaining",damageDone,player.getHitPoints()));


    }


    public Reply combatOutcome(Player player, Battle battle) {
        if (player.getHitPoints() > 0 && battle.getMonster().getHitPoints() <= 0) {
            battle.setVictorious(true);
            player.setNumberOfWins(player.getNumberOfWins()+1);
            battle.getMonster().setAlive(false);
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

    public Reply test(Player player, Battle battle){
        int minDamage = player.getWeapon().getMinDamage();
        int maxDamage = player.getWeapon().getMaxDamage();
        return new Reply(String.format("%s min and %s max",minDamage,maxDamage));
    }


}
