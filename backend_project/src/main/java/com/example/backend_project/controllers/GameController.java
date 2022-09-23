package com.example.backend_project.controllers;

import com.example.backend_project.models.Battle;
import com.example.backend_project.models.Game;
import com.example.backend_project.models.Player;
import com.example.backend_project.models.Reply;
import com.example.backend_project.services.BattleService;
import com.example.backend_project.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    BattleService battleService;
    
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games;
        games = gameService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id){
        Optional<Game> game = gameService.getGameById(id);
        if (game.isPresent()){
            return  new ResponseEntity<>(game.get(),HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }


    @PatchMapping(value = "/{gameId}")
    public ResponseEntity<Reply> processFight(@PathVariable long gameId,@RequestParam long battleId){
        Game game = gameService.getGameById(gameId).get();
        Player player = game.getPlayer();
        Battle battle = battleService.getBattleById(battleId).get();
        return new ResponseEntity<>(battleService.processFight(player,battle),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reply> startNewGame (@RequestParam long playerId){
        Reply reply = gameService.startNewGame(playerId);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @GetMapping(value = "/combat")
    public ResponseEntity<Reply> startEncounter (@RequestParam long battleId){
        Battle battle = battleService.getBattleById(battleId).get();
        return new ResponseEntity<>(battleService.newEncounter(battle), HttpStatus.OK);
    }



}
