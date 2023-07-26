package com.application.dto;

import com.application.entity.Mouse;

public class MouseDTO extends InventoryDTO {
    private String sensorType;

    public MouseDTO() {
    }

    public MouseDTO(int cost, int depreciation, String sensorType) {
        super(cost, depreciation);
        this.sensorType = sensorType;
    }

    public MouseDTO(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public static MouseDTO fromMouse(Mouse mouse) {
        MouseDTO mouseDTO = new MouseDTO();
        mouseDTO.setSensorType(mouse.getSensorType());
        return mouseDTO;
    }
}
