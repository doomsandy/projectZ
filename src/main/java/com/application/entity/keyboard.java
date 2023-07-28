package com.application.entity;

import javax.persistence.Entity;

@Entity
public class Keyboard extends Inventory {

    private String size;

    private String type;

    public Keyboard(int cost, int depreciation, Employee employee, String size, String type) {
        super(cost, depreciation, employee);
        this.size = size;
        this.type = type;
    }

    public Keyboard() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
