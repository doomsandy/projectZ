package com.application.mapper;

import com.application.dto.MouseDTO;
import com.application.entity.Mouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MouseToMouseDtoMapper extends com.application.mapper.Mapper<Mouse, MouseDTO> {

    MouseToMouseDtoMapper INSTANCE = Mappers.getMapper(MouseToMouseDtoMapper.class);

    @Override
    MouseDTO map(Mouse entity);

    @Override
    default Class<Mouse> getMyClass() {
        return Mouse.class;
    }
}
