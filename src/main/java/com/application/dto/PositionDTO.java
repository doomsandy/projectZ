package com.application.dto;

import com.application.entity.Position;

import java.util.HashSet;
import java.util.Set;

public class PositionDTO {

    private String name;

    public PositionDTO(String name) {
        this.name = name;
    }

    public PositionDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setName(position.getName());
        return positionDTO;
    }

    public static Set<PositionDTO> fromPositions(Set<Position> positions) {
        Set<PositionDTO> positionDTOS = new HashSet<>();
        for (Position position : positions) {
            positionDTOS.add(new PositionDTO(position.getName()));
        }
        return positionDTOS;
    }
}