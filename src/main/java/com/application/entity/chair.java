package com.application.entity;

import javax.persistence.Entity;

@Entity
public class Chair extends Inventory{

    private String color;

    private String type;

    public Chair(int cost, int depreciation, Employee employee, String color, String type) {
        super(cost, depreciation, employee);
        this.color = color;
        this.type = type;
    }

    public Chair() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
