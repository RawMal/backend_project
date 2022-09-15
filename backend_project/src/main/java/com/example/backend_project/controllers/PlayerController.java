package com.example.backend_project.controllers;

import com.example.backend_project.models.Player;
import com.example.backend_project.models.Reply;
import com.example.backend_project.models.Shop;
import com.example.backend_project.models.Weapon;
import com.example.backend_project.services.PlayerService;
import com.example.backend_project.services.ShopService;
import com.example.backend_project.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    WeaponService weaponService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id){
        Optional<Player> player = playerService.getPlayerById(id);
        if (player.isPresent()){
            return new ResponseEntity<>(player.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player){
        Player savedPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);

    }

    @PatchMapping
    public ResponseEntity<Reply> goneShopping(@RequestParam long playerId, @RequestParam long weaponId){
        Player player = playerService.getPlayerById(playerId).get();
        Weapon weapon = weaponService.getWeaponById(weaponId).get();
        return new ResponseEntity<>(playerService.buyWeapon(weapon, playerId), HttpStatus.OK);
    }

}
