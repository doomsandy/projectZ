package com.application.mapper;

import com.application.dto.MouseDTO;
import com.application.entity.Mouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MouseDtoToMouseMapper extends com.application.mapper.Mapper<MouseDTO, Mouse> {

    MouseDtoToMouseMapper INSTANCE = Mappers.getMapper(MouseDtoToMouseMapper.class);

    @Override
    Mouse map(MouseDTO entity);

    @Override
    default Class<MouseDTO> getMyClass() {
        return MouseDTO.class;
    }
}

