package com.application.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cost;

    private int depreciation;

    public Inventory() {
    }

    public Inventory(int cost, int depreciation) {
        this.cost = cost;
        this.depreciation = depreciation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(int depreciation) {
        this.depreciation = depreciation;
    }
}