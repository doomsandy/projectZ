package com.application.mapper;

import com.application.dto.MouseDTO;
import com.application.entity.Mouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MouseMapper extends com.application.mapper.Mapper<Mouse, MouseDTO> {
    MouseMapper INSTANCE = Mappers.getMapper(MouseMapper.class);

    @Override
    MouseDTO toDto(Mouse entity);

    @Override
    Mouse toEntity(MouseDTO dto);
}
