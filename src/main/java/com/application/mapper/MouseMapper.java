package com.application.mapper;

import com.application.dto.MouseDTO;
import com.application.entity.Mouse;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface MouseMapper extends com.application.mapper.Mapper<Mouse, MouseDTO> {
    MouseMapper INSTANCE = Mappers.getMapper(MouseMapper.class);
    @Override
    MouseDTO toDto(Mouse entity);
    @Override
    Mouse toEntity(MouseDTO dto);
}