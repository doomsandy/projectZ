package com.application.entity;

import javax.persistence.Entity;

@Entity
public class Mouse extends Inventory {

    private String sensorType;

    public Mouse(int cost, int depreciation, String sensorType, Employee employee) {
        super(cost, depreciation, employee);
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

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + getId() +
                ", cost=" + getCost() +
                ", depreciation=" + getDepreciation() +
                ", sensorType='" + sensorType + '\'' +
                '}';
    }
}