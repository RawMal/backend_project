package com.example.backend_project.models;

import com.example.backend_project.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity (name = "battles")
public class Battle {
    @Autowired
    MonsterService monsterService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "monster")
    private Monster monster;

    @Column(name = "location")
    private String location;

    @Column(name = "victorious")
    private boolean isVictorious;


    public Battle(String location) {
        this.monster = monsterService.getRandomMonster();
        this.location = location;
        this.isVictorious = false;
    }

    public Battle(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Monster getMonster() {
    return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isVictorious() {
        return isVictorious;
    }

    public void setVictorious(boolean victorious) {
        isVictorious = victorious;
    }
}
