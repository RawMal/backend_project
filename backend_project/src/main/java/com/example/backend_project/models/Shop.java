package com.example.backend_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="Shop")
public class Shop {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="shopName")
    private String shopName;

    private List<Weapon> weapons;
    private List<Integer> priceList;


    public Shop(String shopName){
        this.shopName = shopName;
        this.weapons = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    public Shop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Integer> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Integer> priceList) {
        this.priceList = priceList;
    }
}
