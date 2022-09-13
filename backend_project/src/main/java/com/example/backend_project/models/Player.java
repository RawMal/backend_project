package com.example.backend_project.models;

import javax.persistence.*;

@Entity(name = "players")
public class Player {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column (name = "number_of_wins")
    private int numberOfWins;


    public Player (String name, int level){
        this.name = name;
        this.level = level;
        this.numberOfWins = 0;
    }

    public Player(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }
}
