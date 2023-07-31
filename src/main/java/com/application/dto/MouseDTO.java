package com.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MouseDTO extends InventoryDTO {
    private String sensorType;

    public MouseDTO(int cost, int depreciation, String sensorType) {
        super(cost, depreciation);
        this.sensorType = sensorType;
    }

}
