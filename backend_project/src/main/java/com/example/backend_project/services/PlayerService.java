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

    @Autowired
    ShopRepository shopRepository;


    public List<Player> getAllPlayers(){
        return playerRepository.findAll();}

    public Optional<Player> getPlayerById(Long id){
        return playerRepository.findById(id);}

    public Player savePlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Reply buyWeapon (Weapon weapon, Long id){
        Player player = playerRepository.findById(id).get();
        if(weapon.getPrice()<= player.getGold()){
            player.setWeapon(weapon);
            player.setGold(player.getGold()- weapon.getPrice());
            playerRepository.save(player);
            return new Reply("You have obtained a new weapon!");
        } else {
            return new Reply("You can not afford this weapon");
        }

    }
    






}
