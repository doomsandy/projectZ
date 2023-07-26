package com.application.entity;

import javax.persistence.Entity;

@Entity
public class laptop extends Inventory {

    private String size;

    private int ram;

    private int cpu;

    public laptop(int cost, int depreciation, Employee employee, String size, int ram, int cpu) {
        super(cost, depreciation, employee);
        this.size = size;
        this.ram = ram;
        this.cpu = cpu;
    }

    public laptop() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }
}
