package com.application.dto;

import com.application.entity.Chair;

public class ChairDTO extends InventoryDTO {
    private String color;
    private String type;

    public ChairDTO(int cost, int depreciation, String color, String type) {
        super(cost, depreciation);
        this.color = color;
        this.type = type;
    }

    public ChairDTO() {
    }

    public ChairDTO(String color, String type) {
        this.color = color;
        this.type = type;
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

    public static ChairDTO fromChair(Chair chair) {
        ChairDTO chairDTO = new ChairDTO();
        chairDTO.setColor(chair.getColor());
        chairDTO.setType(chair.getType());
        return chairDTO;
    }
}
