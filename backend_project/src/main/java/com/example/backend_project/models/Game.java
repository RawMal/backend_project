package com.example.backend_project.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
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
}
