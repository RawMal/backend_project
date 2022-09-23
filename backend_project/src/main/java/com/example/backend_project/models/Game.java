package com.example.backend_project.models;

import com.example.backend_project.repositories.BattleRepository;
import com.example.backend_project.repositories.MonsterRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "player_id")
    @JsonIgnoreProperties({"games"})
    private Player player;

    @OneToMany(mappedBy = "game")
    @JsonIgnoreProperties({"game"})
    private List<Battle> battles;

    public Game(Player player){
        this.player = player;
        this.battles = new ArrayList<>();
    }

    public Game(){
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addBattle(Battle battle){
        battles.add(battle);
    }
}
