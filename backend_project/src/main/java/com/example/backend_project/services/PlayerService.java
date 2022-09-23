package com.example.backend_project.services;

import com.example.backend_project.models.Player;
import com.example.backend_project.models.Reply;
import com.example.backend_project.models.Weapon;
import com.example.backend_project.repositories.PlayerRepository;
import com.example.backend_project.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();}

    public Optional<Player> getPlayerById(Long id){
        return playerRepository.findById(id);}

    public Player savePlayer(String playerName){
        Player newPlayer = new Player(playerName);
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    public Reply buyWeapon (Weapon weapon, Long id){
        Player player = playerRepository.findById(id).get();
        if(weapon.getPrice()<= player.getGold()){
            player.setWeapon(weapon);
            player.setGold(player.getGold()- weapon.getPrice());
            playerRepository.save(player);
            return new Reply(String.format("You have obtained the %s for %s gold",weapon.getName(),weapon.getPrice()));
        } else {
            return new Reply(String.format("You cannot afford the %s. It costs %s gold",weapon.getName(),weapon.getPrice()));
        }

    }
    






}
