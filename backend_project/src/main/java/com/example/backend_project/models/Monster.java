package com.example.backend_project.models;

import javax.persistence.*;

@Entity(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "level")
    private int level;

    @Column(name = "is_alive")
    private boolean isAlive;

    public Monster(String type, int level) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.isAlive = true;
    }

    public Monster(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
