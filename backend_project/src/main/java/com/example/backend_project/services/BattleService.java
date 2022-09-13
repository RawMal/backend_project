package com.example.backend_project.services;

import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Monster;
import com.example.backend_project.models.Player;
import com.example.backend_project.models.Reply;
import com.example.backend_project.repositories.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BattleService {

    @Autowired
    PlayerService playerService;

    @Autowired
    BattleRepository battleRepository;

    public Optional<Battle> getBattleById(Long id){return battleRepository.findById(id);}

    public Reply combatOutcome(Player player, Battle battle) {
        if (player.getLevel() > battle.getMonster().getLevel()) {
            battle.setVictorious(true);
            battleRepository.save(battle);
            return new Reply ("You've defeated the monster!");
        } else {
            return new Reply ("Oh no, you've been defeated!");

        }

    }


}
