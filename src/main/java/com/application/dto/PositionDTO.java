package com.application.dto;

import com.application.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionDTO {

    private String name;

    public static Set<PositionDTO> fromPositions(Set<Position> positions) {
        Set<PositionDTO> positionDTOS = new HashSet<>();
        for (Position position : positions) {
            positionDTOS.add(new PositionDTO(position.getName()));
        }
        return positionDTOS;
    }
}