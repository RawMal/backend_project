package com.example.backend_project.services;

import com.example.backend_project.models.*;
import com.example.backend_project.repositories.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Reply combatOutcome(Player player, Battle battle) {
        if (player.getLevel() > battle.getMonster().getLevel()) {
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

    public Reply newEncounter(Battle battle) {
        return new Reply(String.format("you are passing through the %s and encountered a %s. Prepare for battle!", battle.getLocation(), battle.getMonster()));
    }


}
