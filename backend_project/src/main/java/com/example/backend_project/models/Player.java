package com.example.backend_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

    @Column(name = "hit_points")
    private int hitPoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"player"})
    private Weapon weapon;


    public Player (String name, int level){
        this.name = name;
        this.level = level;
        this.numberOfWins = 0;
        this.hitPoints = 100;
        this.weapon = new Weapon("sword",1,15,12,0.4f,null);
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

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
