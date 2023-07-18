package com.application.entity;

import javax.persistence.Entity;

@Entity
public class Mouse extends Inventory {

    private String sensorType;

    public Mouse(int cost, int depreciation, String sensorType) {
        super(cost, depreciation);
        this.sensorType = sensorType;
    }

    public Mouse() {

    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
}