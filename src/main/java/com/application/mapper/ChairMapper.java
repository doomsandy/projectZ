package com.application.mapper;

import com.application.dto.ChairDTO;
import com.application.entity.Chair;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChairMapper extends com.application.mapper.Mapper<Chair, ChairDTO> {
    ChairMapper INSTANCE = Mappers.getMapper(ChairMapper.class);

    @Override
    ChairDTO toDto(Chair entity);

    @Override
    Chair toEntity(ChairDTO dto);
}
