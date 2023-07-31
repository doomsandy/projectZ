package com.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChairDTO extends InventoryDTO {
    private String color;
    private String type;

    public ChairDTO(int cost, int depreciation, String color, String type) {
        super(cost, depreciation);
        this.color = color;
        this.type = type;
    }
}
