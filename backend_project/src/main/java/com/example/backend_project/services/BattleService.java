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
    BattleRepository battleRepository;

    @Autowired
    PlayerRepository playerRepository;


    public Optional<Battle> getBattleById(Long id){
        return battleRepository.findById(id);
    }

    public int countVictoriousBattles() {
        return battleRepository.countByIsVictoriousTrue();
    }

    public boolean checkWinCondition(){
        return countVictoriousBattles() == 3;

    }

    public Reply processFight(Player player, Battle battle){
        if (hasPlayerWon(player,battle) && checkWinCondition()){
            return new Reply("You've defeated all of the monster and won the game! Congratulations, your Journey is Complete");
        }else if(hasPlayerWon(player,battle) && !checkWinCondition()){
            player.setHitPoints(100);
            int goldAdded = ThreadLocalRandom.current().nextInt(4,8);
            player.setGold(player.getGold()+goldAdded);
            playerRepository.save(player);
            return  new Reply(String.format("You defeated the monster and gained %s gold! Your adventure continues...",goldAdded));
        } else if(hasMonsterWon(player,battle)){
            return new Reply("You have been defeated");


        } else if(!hasMonsterWon(player,battle) && !hasPlayerWon(player,battle)){

            String monsterName = battle.getMonster().getType();
            int playerDamage = playerAttack(player,battle);
            if (hasPlayerWon(player,battle)){
                return new Reply(String.format("You did %s damage and dealt a killing blow to the %s",playerDamage,monsterName));
            }
            int monsterDamage = monsterAttack(player,battle);
            if (hasMonsterWon(player,battle)){
                return new Reply(String.format("The %s did %s damage and defeated you!",monsterName,monsterDamage));
            }
            return new Reply(String.format("You did %s damage." +
                        "the %s has %sHP remaining.  The %s attacked you for %s damage, you have %sHP remaining"
                    ,playerDamage,monsterName,battle.getMonster().getHitPoints(),monsterName,monsterDamage,player.getHitPoints()));
            }
            return new Reply(null);
        }

    public int playerAttack(Player player, Battle battle){
            int damageDone = ThreadLocalRandom.current().nextInt(player.getWeapon().getMinDamage(),player.getWeapon().getMaxDamage());
            battle.getMonster().setHitPoints(battle.getMonster().getHitPoints()-damageDone);
            battleRepository.save(battle);
            return damageDone;
        }

    public int monsterAttack(Player player, Battle battle){

        int damageDone = ThreadLocalRandom.current().nextInt(battle.getMonster().getMinDamage(),battle.getMonster().getMaxDamage());
        player.setHitPoints(player.getHitPoints()-damageDone);
        playerRepository.save(player);
        return damageDone;
    }


    public boolean hasPlayerWon(Player player, Battle battle) {
        if (player.getHitPoints() > 0 && battle.getMonster().getHitPoints() <= 0) {
            battle.setVictorious(true);
            player.setNumberOfWins(player.getNumberOfWins()+1);
            battle.getMonster().setAlive(false);
            battleRepository.save(battle);
            return true;

        } else {
            return false;

        }

    }

    public boolean hasMonsterWon(Player player, Battle battle){
        if (battle.getMonster().getHitPoints() > 0 && player.getHitPoints() <=0){
            return true;
        } else {
            return false;
        }
    }

    public Reply newEncounter(Battle battle) {
        return new Reply(String.format("You are passing through the %s and encountered a %s. Prepare for battle!", battle.getLocation(), battle.getMonster().getType()));

    }


}
