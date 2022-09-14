package com.example.backend_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int level;
    @Column
    private int maxDamage;
    @Column
    private int minDamage;
    @Column
    private float blockChance;

    @OneToOne(mappedBy = "weapon")
    @JsonIgnoreProperties({"weapon"})
    private Player player;


    public Weapon(String name, int level, int maxDamage, int minDamage, float blockChance, Player player) {
        this.name = name;
        this.level = level;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.blockChance = blockChance;
        this.player = player;
    }

    public Weapon() {
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

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public float getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(float blockChance) {
        this.blockChance = blockChance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
