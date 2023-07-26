package com.application.entity;

import javax.persistence.Entity;

@Entity
public class chair extends Inventory{

    private String color;

    private String type;

    public chair(int cost, int depreciation, Employee employee, String color, String type) {
        super(cost, depreciation, employee);
        this.color = color;
        this.type = type;
    }

    public chair() {

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
